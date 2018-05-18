package com.urjc.master.semv;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import com.urjc.master.semv.Command;

public class Function extends Command {

	private List<Variable> parametros;
	private Ambito ambito;
	private Type returnType;

	public Function(String id, Ambito father) {
		super(id, new Type());
		
		this.ambito = new Ambito(father);
		this.parametros = new ArrayList<>();
	}
	
	public void insertReturnType(Type type) {
		this.returnType = type;
	}
	
	public Type getReturnType() {
		return this.returnType;
	}

	public boolean insertarSingleParametro(String id, Type tipo) {
		Variable v = new Variable(id, tipo);
		boolean success = !parametros.contains(v);

		if (success) {
			this.parametros.add(v);
			this.ambito.insertaIdVariable(new Variable(id, tipo));
		} else {
			System.err.println("Ya existe un parametro " + id + " en la funcion : " + super.getId());
			this.parametros.add(new Variable(id, new Type()));	
		}
		return success;
	}

	public boolean insertarParametros(ListParams params) {
		if (params == null) {
			return false;
		}
		boolean success = true;
		
		for (Entry<String, Type> entry : params.getParametros().entrySet()) {
			success = this.insertarSingleParametro(entry.getKey(), entry.getValue()) && success;
		}
		return success;
	}
	
	public TupleTypes getParamsTypes() {
		TupleTypes types = new TupleTypes();
		
		for (Variable v: this.parametros) {
			types.insert(v.dameTipo());
		}
		return types;
	}
	
	public void eraseAmbito() {
		this.ambito = null;
	}

	public Ambito getAmbito() {
		return this.ambito;
	}
	
	@Override
	public String toString() {
		StringBuffer format = new StringBuffer();

		format.append("Function : " + super.getId() + " return " + super.dameTipo() + "\n");
		format.append("Parameters... \n");
		for (Variable var : this.parametros) {
			format.append("\n\tParameter : " + var.toString() + "\n");
		}
		return format.toString();
	}
}
