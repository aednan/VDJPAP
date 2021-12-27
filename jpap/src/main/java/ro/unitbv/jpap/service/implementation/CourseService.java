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
import ro.unitbv.jpap.dao.db1.DB1CourseRepository;
import ro.unitbv.jpap.dao.db2.DB2CourseRepository;
import ro.unitbv.jpap.mapper.CourseMapper;
import ro.unitbv.jpap.service.ICourseService;

/**
 * @author ADNAN <ADNAN.E@TUTANOTA.DE>
 */


@Service("CourseService")
public class CourseService implements ICourseService {

    @Autowired
    private DB1CourseRepository db1CourseRepository;
    @Autowired
    private DB2CourseRepository db2CourseRepository;
    @Autowired
    private CourseMapper courseMapper;


}
