package ar.edu.unahur.obj2.command.comandos;

import ar.edu.unahur.obj2.command.Programable;

public interface Operable {
    void execute(Programable micro);

    abstract void doExecute(Programable micro); 
    
    void undo(Programable micro);
}
