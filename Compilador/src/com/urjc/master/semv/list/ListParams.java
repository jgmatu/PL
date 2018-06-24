package com.urjc.master.semv.list;

import java.util.ArrayList;
import java.util.List;

import com.urjc.master.semv.commands.Function;
import com.urjc.master.semv.commands.Parametro;
import com.urjc.master.semv.types.TupleTypes;

public class ListParams {

	private List<Parametro> parametros;

	public ListParams() {
		this.parametros = new ArrayList<Parametro>();
	}
	
	public void insertar(Parametro parametro) {
		boolean success = !exist(parametro);
		
		if (success) {
			this.parametros.add(parametro);
		} else {
			System.err.println("The parameter : " + parametro.getId() + " already exist...");
		}
	}
	
	public boolean insertar(Function function, int line) {
		boolean success = true;
		
		for (int i = this.parametros.size() - 1; i >= 0; --i) {
			success = success && function.insertarSingleParametro(parametros.get(i), line);			
		}
		return success;
	}
	
	public boolean exist(Parametro p) {
		for (Parametro parametro : this.parametros) {
			if (parametro.equals(p)) {
				return true;
			}
		}
		return false;
	}
	
	public TupleTypes getListTypes() {
		TupleTypes types = new TupleTypes();
		
		for (Parametro parametro : this.parametros) {
			types.insert(parametro.getTipo());
		}
		return types;
	}

	@Override
	public String toString() {
		StringBuffer format = new StringBuffer();

		for (Parametro parametro: this.parametros) {
			format.append("\n\tParam : " + parametro.toString() + "\n");
		}		
		return format.toString();
	}
}
