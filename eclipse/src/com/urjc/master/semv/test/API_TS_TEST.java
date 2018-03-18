package com.urjc.master.semv.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

import com.urjc.master.semv.APITS.EnumCommands;
import com.urjc.master.semv.APITS.EnumType;
import com.urjc.master.semv.Ambito;
import com.urjc.master.semv.Function;
import com.urjc.master.semv.Variable;



class API_TS_TEST {
	
	@Test
	void test() {
		Ambito root = new Ambito();
		Ambito child = new Ambito(root);
		
		assertTrue(child.insertaId(EnumType.FLOAT, "idBla", EnumCommands.FUNCTION));
		
		Function fun = (Function) child.buscaId("idBla");
		
		assertEquals(EnumType.FLOAT, child.dameTipo(fun));
		assertEquals(EnumType.FLOAT, fun.getTipo());
		
		
		assertTrue(root.insertaId(EnumType.INT, "idBle", EnumCommands.VARIABLE));

		Variable v = (Variable) root.buscaId("idBle");
		
		assertEquals(EnumType.INT, v.getTipo());
		assertEquals(EnumType.INT, root.dameTipo(v));
				
		root.insertaTipo(v, EnumType.FLOAT);
		assertEquals(EnumType.FLOAT, root.dameTipo(v));
	
		
		// Recursive Call to busca id...
		assertNotNull(child.buscaId("idBle"));
		assertNull(child.buscaId("idBlo"));
		
		
		assertFalse(root.insertaId(EnumType.INT, "idBle", EnumCommands.VARIABLE));
		assertFalse(root.insertaId(EnumType.INT, "idBle", EnumCommands.FUNCTION));

		assertTrue(fun.insertarParametro("a", EnumType.FLOAT));
		assertFalse(fun.insertarParametro("a", EnumType.FLOAT));
		assertFalse(fun.insertarParametro("a", EnumType.INT));
		assertTrue(fun.insertarParametro("b", EnumType.INT));
	}
}
