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

package ro.unitbv.jpap.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author ADNAN <ADNAN.E@TUTANOTA.DE>
 */


@Entity
@Table(name = "course")
public class Course implements Serializable {

      @Id
      @Column(name = "id")
      @GeneratedValue(strategy = GenerationType.AUTO)
      private Long id;
      @Column(name = "name")
      private String name;
      @ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
      private List<Student> students;

      public Course() {
      }

      public Course(Long id, String name, List<Student> students) {
            this.id = id;
            this.name = name;
            this.students = students;
      }

      public Long getId() {
            return id;
      }

      public void setId(Long id) {
            this.id = id;
      }

      public String getName() {
            return name;
      }

      public void setName(String name) {
            this.name = name;
      }

      public List<Student> getStudents() {
            if(students == null) students = new ArrayList<>();
            return students;
      }

      public void setStudents(List<Student> students) {
            this.students = students;
      }

      @Override
      public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Course course = (Course) o;
            return Objects.equals(id, course.id) && Objects.equals(name, course.name);
      }

      @Override
      public int hashCode() {
            return Objects.hash(id, name);
      }
}
