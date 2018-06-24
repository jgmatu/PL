package com.urjc.master.semv.interfaces;

import com.urjc.master.semv.commands.Command;
import com.urjc.master.semv.types.Type;

public interface SymbolTable {

	public Command buscar(String id);

	public boolean insertar(Command cmd);

	public Type tipo(String id);

	boolean comparar(Type tipo1, Type tipo2);

}
