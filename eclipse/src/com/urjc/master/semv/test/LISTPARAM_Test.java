package com.urjc.master.semv.test;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

import com.urjc.master.semv.ListParams;
import com.urjc.master.semv.APITS.EnumType;

public class LISTPARAM_Test {

	@Test
	public void testLISTPARAM() {
		ListParams listparam = null;
		assertNull(listparam);
		
		listparam = new ListParams();
		assertNotNull(listparam);		
	}
	
	@Test
	public void testinsertar() {
		ListParams listparam = new ListParams();
		HashMap<String, EnumType> parametros = listparam.getParametros();
		assertEquals(parametros.size(), 0);
		
		listparam.insertar("a", EnumType.FLOAT);
		listparam.insertar("b", EnumType.FLOAT);
		listparam.insertar("c", EnumType.INT);
		listparam.insertar("d", EnumType.INT);
		listparam.insertar("e", EnumType.INT);
		assertEquals(parametros.size(), 2);//The size are the types
	}
}
