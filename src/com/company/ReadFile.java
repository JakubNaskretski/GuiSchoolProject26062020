package com.company;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {

    public int CircleVariablesNumber = 0;

    private int lineCounter = 0;
    private int lineNumber;
    private String path;
    private ArrayList<Integer> variablesList = new ArrayList<>();

    public ReadFile(String file_path){
        path = file_path;
        try {
            this.lineNumber = countLines();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public int countLines() throws IOException {
        FileReader read = new FileReader(path);
        BufferedReader  bufRead = new BufferedReader(read);
        String currentLine;
        while ((currentLine = bufRead.readLine()) != null){
            this.lineCounter++;
        }
        bufRead.close();
        return lineCounter;
    }

//    Reads file and draw shapes
    public void readAndDrawShapes(DrawShapes drawSquarePanel) throws IOException {
        FileReader read = new FileReader(path);
        BufferedReader  bufRead = new BufferedReader(read);
        String currentLine;
        while ((currentLine = bufRead.readLine()) != null){
            variablesList.clear();
            for (String s : currentLine.split(" ")) {
                try{ variablesList.add(Integer.parseInt(s));
                } catch (NumberFormatException e){
                    System.out.println("Provided data does not match any allowed shape type");
                    variablesList.clear();
                }
            }
//            TODO: Pass two arrays in return from Read File and draw shapes from Main Frame
//            If 3 ints in a line calls method painting circle
            if (variablesList.size() == 3) {
                drawSquarePanel.setIsRectangle(false);
                drawSquarePanel.addEllipse(variablesList.get(0),variablesList.get(1),variablesList.get(2),variablesList.get(2));
//            If 4 ints in a line calls method painting rectangle
            } else if (variablesList.size() == 4) {
                drawSquarePanel.setIsRectangle(true);
                drawSquarePanel.addRectangle(variablesList.get(0),variablesList.get(1),variablesList.get(2),variablesList.get(3));
            }
        }
        bufRead.close();
    }

    public String getLine() throws IOException {
        FileReader read = new FileReader(path);
        BufferedReader  bufRead = new BufferedReader(read);
        String currentLine;
        if ((currentLine = bufRead.readLine()) != null){
            return (currentLine);
        }
        bufRead.close();
        return null;
    }


    public List<String> getLines() throws IOException {
        List<String> lines = new ArrayList<>();
        FileReader read = new FileReader(path);
        BufferedReader  bufRead = new BufferedReader(read);
        String currentLine;
        while ((currentLine = bufRead.readLine()) != null){
            lines.add(currentLine);
        }
        bufRead.close();
        return (lines);
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}

