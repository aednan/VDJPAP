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

package ro.unitbv.jpap.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ADNAN <ADNAN.E@TUTANOTA.DE>
 */


public class StudentDTO {

    private Long id;
    private String firstname;
    private String lastname;
    private List<CourseDTO> courses;

    public StudentDTO() {
    }

    public StudentDTO(Long id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public StudentDTO(Long id, String firstname, String lastname, List<CourseDTO> courses) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.courses = courses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<CourseDTO> getCourses() {
        if(courses == null) courses = new ArrayList<>();
        return courses;
    }

    public void setCourses(List<CourseDTO> courses) {
        this.courses = courses;
    }

}
