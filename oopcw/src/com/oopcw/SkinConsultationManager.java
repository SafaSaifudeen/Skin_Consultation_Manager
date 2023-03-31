package com.oopcw;

import java.io.IOException;

public interface SkinConsultationManager {
    void printmenu();


    void addnewdoctor();

    void deleteDoctor();
    void PrintListofDoc();

     void SaveinFile();
    void gui() throws IOException;
}
