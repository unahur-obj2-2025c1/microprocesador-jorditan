package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public abstract class OperableCommand implements Operable {
  @Override
  public void execute(Programable micro) {
    micro.incProgramCounter();
    this.doExecute(micro);
  }

  @Override
  public abstract void doExecute(Programable micro);

  @Override
  public abstract void undo(Programable micro);
}
