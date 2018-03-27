package com.urjc.master.semv.test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import com.urjc.master.semv.LISTPARAM;
import com.urjc.master.semv.APITS.EnumType;

public class LISTPARAM_Test {

	@Test
	public void testLISTPARAM() {
		LISTPARAM listparam = null;
		assertNull(listparam);
		
		listparam = new LISTPARAM();
		assertNotNull(listparam);		
	}
	
	@Test
	public void testinsertar() {
		LISTPARAM listparam = new LISTPARAM();
		HashMap<EnumType, List<String>> parametros = listparam.getParametros();
		assertEquals(parametros.size(), 0);
		
		listparam.insertar("a", EnumType.FLOAT);
		listparam.insertar("b", EnumType.FLOAT);
		listparam.insertar("c", EnumType.INT);
		listparam.insertar("d", EnumType.INT);
		listparam.insertar("e", EnumType.INT);
		assertEquals(parametros.size(), 2);//The size are the types
	}
}
