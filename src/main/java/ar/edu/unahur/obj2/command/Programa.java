package ar.edu.unahur.obj2.command;

import java.util.List;

import ar.edu.unahur.obj2.command.comandos.Operable;

public class Programa {
  private final Programable micro;

  private List<Operable> comandos;

  public Programa(Programable micro) {
    this.micro = micro;
  }

  public void setComandos(List<Operable> listaComandos) {
    this.comandos = listaComandos;
  }

  public List<Operable> getComandos() {
    return this.comandos;
  }

  public void ejecutarTodos(List<Operable> comandos) {
    for (Operable comando : comandos) {
      comando.execute(micro);
    }
  }
}
