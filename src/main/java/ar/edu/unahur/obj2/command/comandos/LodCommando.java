package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class LodCommando extends OperableCommand {
  private Integer addr;

  public LodCommando(Integer addr) {
    this.addr = addr; 
  }

  @Override
  public void doExecute(Programable micro) {
    micro.setAcumuladorA(micro.getAddr(addr));
  }

}
