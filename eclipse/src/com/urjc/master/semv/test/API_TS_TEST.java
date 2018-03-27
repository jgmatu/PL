package com.urjc.master.semv.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.urjc.master.semv.APITS.EnumCommands;
import com.urjc.master.semv.APITS.EnumType;
import com.urjc.master.semv.Ambito;
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

		assertTrue(child.insertaId(EnumType.FLOAT, "idBla", EnumCommands.FUNCTION));
		assertTrue(root.insertaId(EnumType.INT, "idBle", EnumCommands.VARIABLE));

		assertFalse(root.insertaId(EnumType.INT, "idBle", EnumCommands.VARIABLE));
		assertFalse(root.insertaId(EnumType.INT, "idBle", EnumCommands.FUNCTION));
	}

	@Test
	public void testBuscaID() {
		Ambito root = new Ambito();
		Ambito child = new Ambito(root);

		assertTrue(child.insertaId(EnumType.FLOAT, "idBla", EnumCommands.FUNCTION));
		assertTrue(root.insertaId(EnumType.INT, "idBle", EnumCommands.VARIABLE));

		Function fun = (Function) child.buscaId("idBla");
		assertEquals(EnumType.FLOAT, fun.getTipo());

		assertNull(child.buscaId("false"));

		assertNotNull(child.buscaId("idBle"));
		assertNull(child.buscaId("idBlo"));
	}

	@Test
	public void testDameTipo() {
		Ambito root = new Ambito();
		Ambito child = new Ambito(root);

		Function fun = new Function("idBla", EnumType.FLOAT, child);
		assertEquals(EnumType.FLOAT, child.dameTipo(fun));
		assertEquals(EnumType.FLOAT, fun.getTipo());

		Variable v = new Variable("idBle", EnumType.INT);
		assertEquals(EnumType.INT, v.getTipo());
		assertEquals(EnumType.INT, root.dameTipo(v));
	}

	@Test
	public void testInsertaTipo() {
		Ambito root = new Ambito();
		Variable v = new Variable("idBle", EnumType.INT);
		assertEquals(EnumType.INT, root.dameTipo(v));
		assertFalse(EnumType.FLOAT == root.dameTipo(v));

		root.insertaTipo(v, EnumType.FLOAT);
		assertEquals(EnumType.FLOAT, root.dameTipo(v));
	}
}
