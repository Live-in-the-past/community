package com.liveinpast.commnitymvc.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@Controller
@RequestMapping("/alpha")
public class AlphaController {

    @RequestMapping("/http")
    public void http(HttpServletRequest request, HttpServletResponse response) {
        /**
         * retrieve data from http: request
         */
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());

        Enumeration<String> enumeration = request.getHeaderNames();
        while (enumeration.hasMoreElements()) {
            String name = enumeration.nextElement();
            String value = request.getHeader(name);
            System.out.println(name + ": " + value);
        }
        System.out.println(request.getParameter("code"));

        /**
         * response to browser
         */
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            writer.write("<h1>live-in-the-past<h1>");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }

    // Get Request
    // Format: students?current=id&Page=number
    @RequestMapping(path = "/students", method = RequestMethod.GET)
    @ResponseBody
    public String getStudents(@RequestParam(name = "current",required = false, defaultValue = "1") int current,
                              @RequestParam(name = "current",required = false, defaultValue = "10") int page) {
        System.out.println(current);
        System.out.println(page);

        return "some students";
    }

    // Get Request
    // query student id, Format:
    // use "@PathVariable" to automatically input the id value
    @RequestMapping(path = "/student/{id}",method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(@PathVariable("id") int id) {
        System.out.println(id);
        return "a student";
    }

    // Post request
    // construct the same parameter, the controller will receive the value
    // form student.html to saveStudent controller
    @RequestMapping(path = "/student", method = RequestMethod.POST)
    @ResponseBody
    public String saveStudent(String name, int age) {
        System.out.println(name);
        System.out.println(age);
        return "success";
    }

    // response dynamic html data
    @RequestMapping(path = "/teacher", method = RequestMethod.GET)
    public ModelAndView getTeacher() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", "Bran");
        modelAndView.addObject("age",20);
        modelAndView.setViewName("/demo/view");
        return modelAndView;
    }


    @RequestMapping(path = "/school", method = RequestMethod.GET)
    public String getSchool(Model model) {
        model.addAttribute("name","Peking University");
        model.addAttribute("age",200);
        return "/demo/view";
    }

    // Response json data: async request
    // logic: we can't not transfer code from Java to JavaScript, we need something to bridge them, that is json
    // java object -> json string -> js object
    // add annotation "@ResponseBoy" means: return string or somthing else, not html
    @RequestMapping(path = "/emp",method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getEmp() {
        Map<String, Object> emp = new HashMap<>();
        emp.put("name", "Harry");
        emp.put("age",23);
        emp.put("salary",8000.00);
        return emp;
    }

    @RequestMapping(path = "/emps",method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String, Object>> getEmps() {
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String, Object> emp = new HashMap<>();
        emp.put("name", "Harry");
        emp.put("age",23);
        emp.put("salary",8000.00);
        list.add(emp);

        emp = new HashMap<>();
        emp.put("name", "Areon");
        emp.put("age",23);
        emp.put("salary",5000.0);
        list.add(emp);

        emp = new HashMap<>();
        emp.put("name", "Fei");
        emp.put("age",23);
        emp.put("salary",2000.0);
        list.add(emp);

        return list;
    }

}
