package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class StrCommando implements OperableCommand {
  private Integer addr;

  public StrCommando(Integer addr) {
    this.addr = addr;
  }

  @Override
  public void doExecute(Programable micro) {
    micro.setAddr(addr, micro.getAcumuladorA());
  }

  @Override
  public void undo(Programable micro) {
    throw new UnsupportedOperationException("Unimplemented method 'undo'");
  }
}
