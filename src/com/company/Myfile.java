package com.company;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

    public class Myfile {
        public ArrayList<String[]> getLine() {
            return line;
        }

        private ArrayList<String[]> line;

        public void readFileData(String filepath) {
            this.line = new ArrayList<>();
            String thisLine;
            FileReader file = null;
            BufferedReader br = null;
            try {
                file = new FileReader(filepath);
                br = new BufferedReader(file);

                while ((thisLine = br.readLine()) != null) {
                    line.add(thisLine.split(" "));
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (file != null) {
                    try {
                        file.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public void swapLines(byte firstLine, byte secondLine, String filepath){
            //Swapping lines
            BufferedWriter output = null;
            FileWriter file = null;
            try {
                file = new FileWriter(filepath);
                output = new BufferedWriter(file, 3 * 1024);

                Collections.swap(line, secondLine - 1, firstLine - 1);
                for (String[] strings : line) {
                    for (String string : strings) {
                        output.write(string + " ");
                    }
                    output.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (output != null) {
                    try {
                        output.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (file != null) {
                    try {
                        file.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }

        public void swapWords(byte firstLine, byte secondLine, byte firstWord, byte secondWord, String filepath){
            //Swapping words
            FileWriter file = null;
            BufferedWriter output = null;
            try {
                file = new FileWriter(filepath);
                output = new BufferedWriter(file, 3 * 1024);

                String temp = line.get(firstLine - 1)[firstWord - 1];
                line.get(firstLine - 1)[firstWord - 1] = line.get(secondLine-1)[secondWord-1];
                line.get(secondLine-1)[secondWord-1] = temp;

                for (String[] strings : line) {
                    for (String string : strings) {
                        output.write(string + " ");
                    }
                    output.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (output != null) {
                    try {
                        output.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (file != null) {
                    try {
                        file.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
