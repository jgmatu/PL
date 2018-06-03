package com.urjc.master.semv.interfaces;

import com.urjc.master.semv.commands.Command;
import com.urjc.master.semv.types.Type;

public interface APITS {

	public Command buscaId(String id);

	public boolean insertaTipo(String id, Type tipo);

	public Type dameTipo(String id);

	boolean tiposComp(Type tipo1, Type tipo2);

	// ExpTipo -> TBAS || TBAS x TBAS x TBAS || TBAS x TBAS -> TBAS
}
