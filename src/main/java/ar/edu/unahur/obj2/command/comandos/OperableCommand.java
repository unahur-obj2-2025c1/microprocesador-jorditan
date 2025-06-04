package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public abstract class OperableCommand implements Operable {
  private Programable estadoPrevio;

  @Override
  public void execute(Programable micro) {
    this.estadoPrevio = micro.copy();
    micro.incProgramCounter();
    this.doExecute(micro);
  }

  @Override
  public abstract void doExecute(Programable micro);

  @Override
  public void undo(Programable micro) {
    micro.copyFrom(estadoPrevio);
  }
}
