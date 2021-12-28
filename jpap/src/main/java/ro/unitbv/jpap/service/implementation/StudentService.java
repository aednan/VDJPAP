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

package ro.unitbv.jpap.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.unitbv.jpap.dao.db1.DB1StudentRepository;
import ro.unitbv.jpap.dao.db2.DB2StudentRepository;
import ro.unitbv.jpap.dto.StudentDTO;
import ro.unitbv.jpap.mapper.StudentMapper;
import ro.unitbv.jpap.service.IStudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ADNAN <ADNAN.E@TUTANOTA.DE>
 */


@Service("StudentService")
public class StudentService implements IStudentService {

    @Autowired
    private DB1StudentRepository db1StudentRepository;
    @Autowired
    private DB2StudentRepository db2StudentRepository;
    @Autowired
    private StudentMapper studentMapper;

//    @Override
//    public void addStudent(StudentDTO studentDTO) {
//        db1StudentRepository.save(studentMapper.toStudent(studentDTO));
////      db2StudentRepository.save(studentMapper.toStudent(studentDTO));
//    }

    @Override
    public List<StudentDTO> fetchAll() {
        List<StudentDTO> students = new ArrayList<>();

        students.addAll(db1StudentRepository.findAll().parallelStream()
        .map(studentMapper::toDTO).collect(Collectors.toList()));

        students.addAll(db2StudentRepository.findAll().parallelStream()
                .map(studentMapper::toDTO).collect(Collectors.toList()));
        return students;
    }


}
