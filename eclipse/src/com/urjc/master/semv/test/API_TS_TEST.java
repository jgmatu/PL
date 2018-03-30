package com.urjc.master.semv.test;

import static org.junit.Assert.*;

import org.junit.Test;


import com.urjc.master.semv.APITS.EnumType;
import com.urjc.master.semv.Ambito;
import com.urjc.master.semv.Command;
import com.urjc.master.semv.Function;
import com.urjc.master.semv.Variable;

public class API_TS_TEST {

	@Test
	public void testAmbito() {
		Ambito root = null;
		Ambito child = null;
		assertNull(root);
		assertNull(child);

		root = new Ambito();
		child = new Ambito(root);
		assertNotNull(root);
		assertNotNull(child);
	}

	@Test
	public void testInsertaId() {
		Ambito root = new Ambito();
		Ambito child = new Ambito(root);

		assertTrue(child.insertaIdFunction("idBla"));		
		Command cmd = child.buscaId("idBla");
		assertNotNull(cmd);
		if (cmd instanceof Function) {
			Function fun = (Function) cmd;
			fun.insertaTipo(EnumType.VOID);
		}
		
		assertTrue(root.insertaIdVariable(new Variable("idBle", EnumType.INT)));
		assertFalse(root.insertaIdVariable(new Variable("idBle", EnumType.INT)));
		assertFalse(root.insertaIdFunction("idBle"));
		
	}

	@Test
	public void testBuscaID() {
		Ambito root = new Ambito();
		Ambito child = new Ambito(root);

		assertTrue(child.insertaIdFunction("idBla"));
		Command cmd = child.buscaId("idBla");
		assertNotNull(cmd);
		if (cmd instanceof Function) {
			Function func = (Function) cmd;
			func.insertaTipo(EnumType.FLOAT);
		} else {
			fail();
		}
		
		assertTrue(root.insertaIdVariable(new Variable("idBle", EnumType.INT)));
		
		cmd = child.buscaId("idBla");
		if (cmd instanceof Function) {
			Function fun = (Function) cmd;
			assertEquals(EnumType.FLOAT, fun.dameTipo());			
		}
		
		assertNull(child.buscaId("false"));
		assertNotNull(child.buscaId("idBle"));
		assertNull(child.buscaId("idBlo"));
	}

	@Test
	public void testDameTipo() {
		Ambito root = new Ambito();
		Ambito functionAmbito = new Ambito(root);

		Function fun = new Function("idBla", functionAmbito);
		
		root.insertaIdFunction("idBla");
		assertEquals(EnumType.ERROR, functionAmbito.dameTipo("idBla"));
		
		fun.insertaTipo(EnumType.FLOAT);
		assertEquals(EnumType.FLOAT, fun.dameTipo());

		Variable v = new Variable("idBle", EnumType.INT);
		assertEquals(EnumType.INT, v.dameTipo());
		functionAmbito.insertaIdVariable(new Variable("idBle", EnumType.INT));
		assertEquals(EnumType.INT, functionAmbito.dameTipo("idBle"));
	}

	@Test
	public void testInsertaTipo() {
		Ambito root = new Ambito();

		root.insertaIdVariable(new Variable("idBle", EnumType.INT));

		assertEquals(EnumType.INT, root.dameTipo("idBle"));
		assertNotEquals(EnumType.FLOAT, root.dameTipo("idBle"));

		root.insertaTipo("idBle", EnumType.FLOAT);
		assertEquals(EnumType.FLOAT, root.dameTipo("idBle"));
	}
}
