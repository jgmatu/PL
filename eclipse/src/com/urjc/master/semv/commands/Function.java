package com.urjc.master.semv.commands;

import java.util.ArrayList;
import java.util.List;

import com.urjc.master.semv.ambito.Ambito;
import com.urjc.master.semv.commands.Command;
import com.urjc.master.semv.list.ListParams;
import com.urjc.master.semv.types.TupleTypes;
import com.urjc.master.semv.types.Type;

public class Function extends Command {

	private ListParams parametros;
	private Ambito ambito;
	private List<Type> returnTypes;

	public Function(String id, ListParams parametros, Type t) {
		super(id, t);
		
		this.parametros = new ListParams();
		if (parametros != null) {
			this.parametros = parametros;			
		}
	}

	public Function(String id, Ambito father) {
		super(id, new Type());
		
		this.ambito = new Ambito(father);
		this.parametros = new ListParams();
		this.returnTypes = new ArrayList<>();
	}

	public void insertReturnTypes(TupleTypes types) {
		for (Type type : types.getTupleTypes()) {
			if (type != null && type.isReturn()) {
				this.returnTypes.add(type);
			}
		}
	}

	public void checkReturnType(Type t, int line) {
		for (Type type : this.returnTypes) {
			if (!type.equals(t)) {
				System.err.println("\nLine:" + type.getLine() + " Error on return type incompatible return\n" + "Line:"
						+ type.getLine() + " Sentence return : " + type.toString() + "Line:" + line
						+ " Function defined type return :" + t.toString());
			}
		}
		
		if (this.returnTypes.size() == 0 && !t.isVoid()) {
			System.err.println("Line: " + line + " The function " + this.getId() + " should be have a return sentence.");
		}
	}

	public boolean insertarSingleParametro(Parametro parametro, int line) {
		boolean success = !this.parametros.exist(parametro);

		if (success) {
			this.parametros.insertar(parametro);
			this.ambito.insertaIdVariable(new Variable(parametro.getId(), parametro.getTipo()));
		} else {
			System.err.println("Line:" + line + "Ya existe un parametro " + parametro.getId() + " en la funcion : "
					+ super.getId());
		}
		return success;
	}

	public boolean insertarParametros(ListParams params, int line) {
		if (params == null) {
			return false;
		}
		return params.insertar(this, line);
	}

	public TupleTypes getListParamsTypes() {
		return this.parametros.getListTypes();
	}

	public void eraseAmbito() {
		this.ambito = null;
	}

	public Ambito getAmbito() {
		return this.ambito;
	}

	public void usage(TupleTypes defTypes, TupleTypes callTypes, int line) {
		StringBuffer format = new StringBuffer();
		format.append("Line:" + line);
		format.append(" The function is bad used \n");
		format.append("Line:" + line + " Function defined: " + this.getId() + " " + defTypes.toString());
		format.append("Line:" + line + " Function called: " + this.getId() + " " + callTypes.toString());
		System.err.println(format);
	}

	@Override
	public String toString() {
		StringBuffer format = new StringBuffer();

		format.append("Function : " + super.getId() + " return " + super.dameTipo() + "\n");
		format.append("Parameters... \n");
		format.append(this.parametros.toString());
		return format.toString();
	}
}
