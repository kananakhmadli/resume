package com.company.util;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

public class ControllerUtil {

    public static void errorPage(HttpServletResponse res, Exception e) {
        try {
            e.printStackTrace();
            res.sendRedirect("error?msg=" + e.getMessage());

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
