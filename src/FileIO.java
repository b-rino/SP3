

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public interface FileIO<T> {


    public List<T> readData(enumPathing ePath);


    public void saveData(List<T> items, enumPathing ePath, String header);
}
