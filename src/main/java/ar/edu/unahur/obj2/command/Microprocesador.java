package ar.edu.unahur.obj2.command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ar.edu.unahur.obj2.command.comandos.Operable;
import ar.edu.unahur.obj2.command.excepctions.MicroException;

public class Microprocesador implements Programable {
  private Integer acumuladorA;
  private Integer acumuladorB;
  private Integer programCounter = 0;
  private Map<Integer, Integer> memoria = new HashMap<>();
  
  @Override
  public void run(List<Operable> operaciones) {
    operaciones.forEach(op -> op.execute(this));
  }

  @Override
  public void incProgramCounter() {
    programCounter++; 
  }

  @Override
  public Integer getProgramCounter() {
    return programCounter;
  }

  @Override
  public void setAcumuladorA(Integer value) {
      acumuladorA = value;
  }

  @Override
  public Integer getAcumuladorA() {
    return this.acumuladorA;
  }

  @Override
  public void setAcumuladorB(Integer value) {
    acumuladorB = value;
  }

  @Override
  public Integer getAcumuladorB() {
    return this.acumuladorB;
  }

  @Override
  public void copyFrom(Programable otro) {
    this.acumuladorA = otro.getAcumuladorA();
    this.acumuladorB = otro.getAcumuladorB();
    this.programCounter = otro.getProgramCounter();
    this.memoria = otro.getMemoria();
  }

  @Override
  public Programable copy() {
    Microprocesador copia = new Microprocesador();
    copia.acumuladorA = this.acumuladorA;
    copia.acumuladorB = this.acumuladorB;
    copia.programCounter = this.programCounter;
    copia.memoria = new HashMap<>(this.memoria);  // Copia profunda
    return copia;
  }

  @Override
  public void reset() {
    acumuladorA = 0;
    acumuladorB = 0;
    programCounter = 0;
  }

  @Override
  public void setAddr(Integer direccion, Integer valor) {
    memoria.put(direccion, valor);
  }

  @Override
  public Integer getAddr(Integer direccion) {
    if (direccion > 1023) {
      throw new MicroException("La memoria solo puede ser accedida de la dirección 0 a la 1023");
    }
    return memoria.getOrDefault(direccion, 0); 
  }

  @Override 
  public void undo(List<Operable>operaciones) {
    Integer longitud = operaciones.size();
    operaciones.get(longitud - 1).undo(this);;
  }

  @Override
  public Map<Integer, Integer> getMemoria() {
    return this.memoria;
  }
}