import React, { Component } from "react";
import PropTypes from 'prop-types';
import Box from '@mui/material/Box';
import Collapse from '@mui/material/Collapse';
import IconButton from '@mui/material/IconButton';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Typography from '@mui/material/Typography';
import Paper from '@mui/material/Paper';
import KeyboardArrowDownIcon from '@mui/icons-material/KeyboardArrowDown';
import KeyboardArrowUpIcon from '@mui/icons-material/KeyboardArrowUp';
import axios from 'axios';
import { Button } from "@mui/material";
import AuthService from '../service/AuthService';

function createData(firstname, lastname, course) {
  return {
    firstname,
    lastname,
    course,
  };
}

function Row(props) {
  const { row } = props;
  const [open, setOpen] = React.useState(false);

  return (
    <React.Fragment>
      <TableRow sx={{ '& > *': { borderBottom: 'unset' } }}>
        <TableCell>
          <IconButton
            aria-label="expand row"
            size="small"
            onClick={() => setOpen(!open)}
          >
            {open ? <KeyboardArrowUpIcon /> : <KeyboardArrowDownIcon />}
          </IconButton>
        </TableCell>
        <TableCell component="th" scope="row">
          {row.firstname} {row.lastname} 
        </TableCell>
        <TableCell align="left">{row.firstname}</TableCell>
        <TableCell align="left">{row.lastname}</TableCell>
      </TableRow>
      <TableRow>
        <TableCell style={{ paddingBottom: 0, paddingTop: 0 }} colSpan={6}>
          <Collapse in={open} timeout="auto" unmountOnExit>
            <Box sx={{ margin: 1 }}>
              <Typography variant="h6" gutterBottom component="div">
                Courses
              </Typography>
              <Table size="small" aria-label="purchases">
                <TableHead>
                  <TableRow>
                    <TableCell>Course name</TableCell>
                  </TableRow>
                </TableHead>
                <TableBody>
                  {row.course.map((courseRow) => (
                    <TableRow key={courseRow.firstname}>
                      <TableCell component="th" scope="row">
                        {courseRow.name}
                      </TableCell>
                    </TableRow>
                  ))}
                </TableBody>
              </Table>
            </Box>
          </Collapse>
        </TableCell>
      </TableRow>
    </React.Fragment>
  );
}

Row.propTypes = {
  row: PropTypes.shape({
    firstname: PropTypes.string.isRequired,
    lastname: PropTypes.string.isRequired,
    course: PropTypes.arrayOf(
      PropTypes.shape({
        name: PropTypes.string.isRequired,
      }),
    ).isRequired,
  }).isRequired,
};


export class TableGComponent extends Component {

  constructor(props){
    super(props);

    this.state = {
      rows: []
    }
  } 


  componentDidMount(){ 
    const students = []; 
   
    axios('http://localhost:8080/student/fetchAll', {credentials: "include"})
   
    .then( response => {

    response.data.forEach(element => {
        students.push(createData(element.firstname, element.lastname, element.courses)); 
    });


    this.setState({
     rows: students
     })
     

    })
    .catch ( error => {
        console.log("error");
    });


  }

  render() {
    if (this.state.rows.length === 0) return null;
  return (
    <>
    <TableContainer component={Paper}>
      <Table aria-label="collapsible table">
        <TableHead>
          <TableRow>
            <TableCell />
            <TableCell>Student</TableCell>
            <TableCell align="left">Firstname</TableCell>
            <TableCell align="left">Lastname</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
          {this.state.rows.map((row) => (
            <Row key={row.firstname} row={row} />
          ))}
        </TableBody>
      </Table>
    </TableContainer>

  </>

  );
}
}

export default TableGComponent;

