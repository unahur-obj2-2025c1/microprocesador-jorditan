package ar.edu.unahur.obj2.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ar.edu.unahur.obj2.command.comandos.Operable;
import ar.edu.unahur.obj2.command.excepctions.MicroException;

public class Microprocesador implements Programable {
  private Integer acumuladorA;
  private Integer acumuladorB;
  private Integer programCounter = 0;
  private Map<Integer, Integer> memoria = new HashMap<>();

  // private List<Operable> operaciones = new ArrayList<>();
  @Override
  public void run(List<Operable> operaciones) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'run'");
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
  public void copyFrom(Programable programable) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'copyFrom'");
  }

  @Override
  public Programable copy() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'copy'");
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
      new MicroException("La memoria solo puede ser accedida de la dirección 0 a la 1023");
    }
    return memoria.getOrDefault(direccion, 0); 
  }
}