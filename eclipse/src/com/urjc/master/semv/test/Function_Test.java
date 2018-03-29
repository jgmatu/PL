package com.urjc.master.semv.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.urjc.master.semv.APITS.EnumType;
import com.urjc.master.semv.Ambito;
import com.urjc.master.semv.Function;
import com.urjc.master.semv.ListParams;

public class Function_Test {

	@Test
	public void testFunction() {
		Function fun = null;
		assertNull(fun);
		
		Ambito root = new Ambito();
		fun = new Function("main", EnumType.FLOAT, root);
		assertNotNull(fun);
		
		assertEquals(EnumType.FLOAT, fun.getTipo());
	}
	
	@Test
	public void testInsertarSingleParametro() {
		Function fun = new Function("main", EnumType.FLOAT, new Ambito());
		assertTrue(fun.insertarSingleParametro("a", EnumType.FLOAT));
		assertFalse(fun.insertarSingleParametro("a", EnumType.FLOAT));
		assertFalse(fun.insertarSingleParametro("a", EnumType.INT));
		assertTrue(fun.insertarSingleParametro("b", EnumType.INT));
	}
	
/*	
	@Test
	public void testInsertarListParametros() {
		Function fun = new Function("main", EnumType.FLOAT, new Ambito());
		List<String> ids = new LinkedList<String>();
		ids.add("a");
		ids.add("b");
		ids.add("c");
		assertTrue(fun.insertarListParametros(ids, EnumType.FLOAT));
		
		List<String> ids2 = new LinkedList<String>();
		ids2.add("a");
		ids2.add("b");
		ids2.add("b");
		assertFalse(fun.insertarListParametros(ids2, EnumType.FLOAT));
	}
*/
	
	@Test
	public void testInsertarParametroso() {
		Function fun = new Function("main", EnumType.FLOAT, new Ambito());
		
		ListParams listparam = new ListParams();
		listparam.insertar("a", EnumType.FLOAT);
		listparam.insertar("b", EnumType.FLOAT);
		listparam.insertar("c", EnumType.INT);
				
		assertTrue(fun.insertarParametros(listparam));
		
		ListParams listparam2 = new ListParams();
		listparam2.insertar("a", EnumType.FLOAT);
		listparam2.insertar("b", EnumType.FLOAT);
		listparam2.insertar("b", EnumType.FLOAT);
		listparam2.insertar("c", EnumType.INT);
		assertFalse(fun.insertarParametros(listparam2));
	}

}
