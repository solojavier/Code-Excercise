package solojavier.cyrusinnovation.codeexercise;

enum InputFiles {
    COMMA 	("input_files\\comma.txt",",","01243", "M/dd/yyyy"),
    PIPE	("input_files\\pipe.txt","\\|","01354", "M-dd-yyyy"),
    SPACE	("input_files\\space.txt"," ","01345", "M-dd-yyyy");
    
    private final String path;
    private final String delimiter;
    private final String order;
    private final String dateFormat;
    
    InputFiles(String path, String delimiter, String order, String dateFormat) {
        this.path = path;
        this.delimiter = delimiter;
        this.order = order;
        this.dateFormat = dateFormat;
    }
    
    public String getPath()   { return path; }
    public String getDelimiter()   { return delimiter; }
    public String getOrder()   { return order; }
    public String getDateFormat()   { return dateFormat; }
}
