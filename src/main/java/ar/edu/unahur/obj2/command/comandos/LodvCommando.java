package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class LodvCommando extends OperableCommand {
  private Integer valor;

  public LodvCommando(Programable micro, Integer val) {
    this.valor = val;
  }

  @Override
  public void doExecute(Programable micro) {
    micro.setAcumuladorA(valor);
  }
  
}
