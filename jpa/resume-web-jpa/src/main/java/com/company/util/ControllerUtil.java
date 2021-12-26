package com.company.util;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ControllerUtil {

    private ControllerUtil() {
    }

    public static void errorPage(HttpServletResponse res, Exception e) {
        try {
            e.printStackTrace();
            res.sendRedirect("error?msg=" + e.getMessage());

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}