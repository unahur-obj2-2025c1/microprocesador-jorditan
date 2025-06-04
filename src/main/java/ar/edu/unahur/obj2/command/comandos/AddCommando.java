package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class AddCommando extends OperableCommand {
  @Override
  public void doExecute(Programable micro) {
    micro.setAcumuladorA(micro.getAcumuladorA() + micro.getAcumuladorB());
    micro.setAcumuladorB(0);
  }
}
