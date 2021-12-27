/**
 *  Copyright (C) 2021  the original author or authors.
 *
 * 		This program is free software: you can redistribute it and/or modify
 * 		it under the terms of the GNU General Public License as published by
 * 		the Free Software Foundation, either version 3 of the License, or
 * 		(at your option) any later version.
 *
 * 		This program is distributed in the hope that it will be useful,
 * 		but WITHOUT ANY WARRANTY; without even the implied warranty of
 * 		MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * 		GNU General Public License for more details.
 *
 * 		You should have received a copy of the GNU General Public License
 * 		along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package ro.unitbv.jpap.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.unitbv.jpap.dto.StudentDTO;
import ro.unitbv.jpap.service.IStudentService;

import java.util.List;

/**
 * @author ADNAN <ADNAN.E@TUTANOTA.DE>
 */


@RestController
@CrossOrigin(origins = {"http://localhost:3000"},allowCredentials = "true")
public class StudentController {

    @Autowired
    @Qualifier("StudentService")
    IStudentService studentService;

    @GetMapping("/")
    public ResponseEntity<String> login(){
        return ResponseEntity.ok().build();
    }

    @GetMapping("/student/fetchAll")
    public ResponseEntity<List<StudentDTO>> fetchAll(){
        return ResponseEntity.ok().body(studentService.fetchAll());
    }

//    @PostMapping("/add")
//    public ResponseEntity<StudentDTO> addStudent(@RequestBody(required = true) StudentDTO student){
////     studentService.addStudent(student);
//
//     return ResponseEntity.ok().body(student);
//    }


}
