package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class LodvCommando extends OperableCommand {

  public LodvCommando(Programable micro, Integer val) {
    micro.setAcumuladorA(val);
  }

  @Override
  public void doExecute(Programable micro) {
    
  }

  @Override
  public void undo(Programable micro) {
    throw new UnsupportedOperationException("Unimplemented method 'undo'");
  }
  
}
