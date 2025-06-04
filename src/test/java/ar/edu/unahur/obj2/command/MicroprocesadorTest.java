package ar.edu.unahur.obj2.command;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.command.comandos.AddCommando;
import ar.edu.unahur.obj2.command.comandos.LodCommando;
import ar.edu.unahur.obj2.command.comandos.LodvCommando;
import ar.edu.unahur.obj2.command.comandos.NopComando;
import ar.edu.unahur.obj2.command.comandos.Operable;
import ar.edu.unahur.obj2.command.comandos.StrCommando;
import ar.edu.unahur.obj2.command.comandos.SwapCommando;

public class MicroprocesadorTest {
  private Microprocesador microprocesador = new Microprocesador();

  private Programa programa = new Programa(microprocesador);

  @BeforeEach 
  void setUp() {
    microprocesador.reset();
  }

  @Test 
  void LasEjecucionesDelComandoNopAumentanElContador() {
    List<Operable> comandos = List.of(
    new NopComando(),
    new NopComando(),
    new NopComando()
    );

    programa.setComandos(comandos);

    microprocesador.run(programa.getComandos());

    assertEquals(3, microprocesador.getProgramCounter());
  }

  @Test 
  void lasSumasSeEjecutanCorrectamente() {
    List<Operable> comandos = List.of(
      new LodvCommando(microprocesador, 20),
      new SwapCommando(),
      new LodvCommando(microprocesador, 17),
      new AddCommando()
    );

    programa.setComandos(comandos);
    microprocesador.run(programa.getComandos());

    assertEquals(37, microprocesador.getAcumuladorA());
    assertEquals(0, microprocesador.getAcumuladorB());
    assertEquals(4, microprocesador.getProgramCounter());
  }

  @Test 
  void testDeSumaSegudoNivel() {
    List<Operable> comandos = List.of(
      new LodvCommando(microprocesador, 2),
      new StrCommando(0),
      new LodvCommando(microprocesador, 8),
      new SwapCommando(),
      new LodvCommando(microprocesador, 5),
      new AddCommando(),
      new SwapCommando(),
      new LodCommando(0),
      new AddCommando()
    );

    programa.setComandos(comandos);
    microprocesador.run(programa.getComandos());

    assertEquals(15, microprocesador.getAcumuladorA());
    assertEquals(0, microprocesador.getAcumuladorB());
  }

  @Test
  void pruebaDeUndo() {

  List<Operable> comandos = List.of(
    new LodvCommando(microprocesador, 8),
    new SwapCommando()
  );

  programa.setComandos(comandos);
  microprocesador.run(programa.getComandos());

  assertEquals(0, microprocesador.getAcumuladorA()); 

  microprocesador.undo(comandos);
  
  assertEquals(8, microprocesador.getAcumuladorA());  
}
}
