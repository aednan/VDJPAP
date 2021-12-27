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

package ro.unitbv.jpap.mapper;

import org.mapstruct.*;
import ro.unitbv.jpap.dto.StudentDTO;
import ro.unitbv.jpap.entity.Student;

/**
 * @author ADNAN <ADNAN.E@TUTANOTA.DE>
 */


@Mapper(componentModel = "spring" , uses = {CourseMapper.class},
        injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedSourcePolicy = ReportingPolicy.IGNORE )
public interface StudentMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "firstname", target = "firstname")
    @Mapping(source = "lastname", target = "lastname")
    @Mapping(source = "courses", target = "courses")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    public StudentDTO toDTO (Student student);

    @InheritInverseConfiguration(name = "toDTO")
    public Student toStudent (StudentDTO studentDTO);



}
