package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class StrCommando extends OperableCommand {
  private Integer addr;

  public StrCommando(Integer addr) {
    this.addr = addr;
  }

  @Override
  public void doExecute(Programable micro) {
    micro.setAddr(addr, micro.getAcumuladorA());
  }

}
