package com.urjc.master.semv.interfaces;

import com.urjc.master.semv.commands.Command;
import com.urjc.master.semv.types.Type;

public interface SymbolTable {

	public Command buscaId(String id);

	public boolean insertaCommand(String id, Type tipo);

	public Type dameTipo(String id);

	boolean compararTipos(Type tipo1, Type tipo2);

}
