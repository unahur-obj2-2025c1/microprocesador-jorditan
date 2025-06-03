package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class NopComando implements Operable {

  @Override
  public void doExecute(Programable micro) {}

  @Override
  public void undo(Programable micro) {}
}
