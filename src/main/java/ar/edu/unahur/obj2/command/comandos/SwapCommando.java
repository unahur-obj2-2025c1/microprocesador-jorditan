package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public class SwapCommando extends OperableCommand {

  @Override
  public void doExecute(Programable micro) {
    Integer actualValA = micro.getAcumuladorA();
    Integer actualValB = micro.getAcumuladorB();
    
    micro.setAcumuladorA(actualValB);
    micro.setAcumuladorB(actualValA);
  }

  
}
