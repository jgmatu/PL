package com.urjc.master.semv.ambito;

import java.util.HashMap;
import java.util.Map.Entry;

import com.urjc.master.semv.commands.Command;
import com.urjc.master.semv.commands.Function;
import com.urjc.master.semv.commands.Variable;
import com.urjc.master.semv.interfaces.SymbolTable;
import com.urjc.master.semv.list.Lid;
import com.urjc.master.semv.types.TupleTypes;
import com.urjc.master.semv.types.Type;

public class Ambito implements SymbolTable {

	private Ambito father;
	private HashMap<String, Command> ambito;

	public Ambito() {
		this.father = null;
		this.ambito = new HashMap<String, Command>();
	}

	public Ambito(Ambito father) {
		this.father = father;
		this.ambito = new HashMap<String, Command>();
	}

	public Function insertaIdFunction(String idLexema) {
		Function function = new Function(idLexema, this);
		
		if (!this.addEntry(idLexema, function)) {
			return null;
		}
		return function;
	}
	
	public void insertar(Function function) {
		this.ambito.put(function.getId(), function);
	}
	
	public boolean insertaIdVariable(Variable var) {
		return this.addEntry(var.getId(), var);		
	}
		
	private boolean addEntry(String id, Command command) {
		boolean success = !existIdOnAmbito(id);		

		if (success) {
			this.ambito.put(id, command);			
		} else {
			printErrorAlreadyExists(command);
		}
		return success;
	}
	
	private boolean existIdOnAmbito(String id) {
		return this.ambito.containsKey(id);
	}
	
	private void printErrorAlreadyExists(Command command) {
		System.err.println("The " + command.getClass().getSimpleName() + " " + command.getId() + " already exist\n");
	}

	public Command buscaId(String id) {
		if (this.ambito.containsKey((id))) {
			return this.ambito.get(id);			
		} 
		if (hasFather()) {
			return this.father.buscaId(id);				
		}		
		return null;
	}
	
	public boolean hasFather(){
		return this.father != null;
	}
	
	public Ambito getFather(){
		return this.father;
	}

	public boolean insertaTipo(String id, Type tipo) {
		boolean exist = this.ambito.containsKey(id);
		
		if(exist){
			this.ambito.get(id).setTipo(tipo);
		}
		return exist;
	}

	public TupleTypes buscaIdsType(Lid lid) {
		TupleTypes types = new TupleTypes();
		
		if (lid == null) {
			return types;
		}
		for (String id : lid.getList()) {
			types.insert(dameTipo(id));
		}
		return types;
	}
		
	@Override
	public boolean tiposComp(Type tipo1, Type tipo2) {
		return tipo1 == tipo2;
	}
		
	@Override
	public Type dameTipo(String id) {
		if (this.ambito.containsKey(id)) {
			return this.ambito.get(id).dameTipo();
		}
		if (this.hasFather()) {
			return this.father.dameTipo(id);
		}
		return new Type();
	}

	@Override
	public String toString() {
		StringBuffer format = new StringBuffer();
				
		format.append("Ambito...\n");
		for (Entry<String, Command> entry : this.ambito.entrySet()) {
			Command cmd = entry.getValue();
			
			switch(cmd.getClass().getSimpleName()){
				case "Function": format.append("Defined funcion... " + cmd.toString() + "\n"); break;
				case "Variable": format.append("Defined variable : " + cmd.toString() + "\n"); break;
			}
		}
		
		if (this.father != null) {
			format.append("\nWe have Father ");
			format.append(this.father.toString());			
		} else {
			format.append("................... END AMBITO .......................\n");			
		}
		return format.toString();
	}
}
