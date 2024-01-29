package com.database.databasedemo.JDBC;

import com.database.databasedemo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@Repository //it talks to the DB so it's a repository
public class PersonJdbcDao {

    @Autowired //for jdbc to connect to db
    JdbcTemplate jdbcTemplate;

    //select * from person
    public List<Person> retrieveAll(){
        String sql = "select * from person";
        return jdbcTemplate.query(sql,
                //new BeanPropertyRowMapper<>(Person.class));
                new PersonRowMapper());
    }

    //select person by id
    public Person retrieveById(long id){
        String sql = "SELECT * FROM PERSON WHERE ID=?";
        return jdbcTemplate.queryForObject(sql,
                new Object[]{id},
                //new BeanPropertyRowMapper<>(Person.class));
                new PersonRowMapper());
    }

    //select by name or location
    public Person retrieveByName(String name){
        String sql = "SELECT * FROM PERSON WHERE NAME LIKE ?";
        return jdbcTemplate.queryForObject(sql,
                new Object[]{name},
                //new BeanPropertyRowMapper<>(Person.class));
                new PersonRowMapper());

    }


    public Person retrieveByLocation(String location){
        String sql = "SELECT * FROM PERSON WHERE LOCATION LIKE ?";
        return jdbcTemplate.queryForObject(sql,
                new Object[]{location},
                //new BeanPropertyRowMapper<>(Person.class));
                new PersonRowMapper());
    }


    //delete person by id, returns how many rows were deleted
    public int deleteById(long id){
        String sql = "DELETE FROM PERSON WHERE ID=?";
        return jdbcTemplate.update(sql, id);

    }

    //insert person object
    public int insertPerson(Person person){
        String sql = "INSERT INTO PERSON " +
                "(ID, name, location, birthday) " +
                "VALUES (?, ?, ?, ?)";

        return jdbcTemplate.update(sql, new Object[]{
                person.getId(), person.getName(),
                person.getLocation(),
                new Timestamp(person.getBirthday().getTime())});
    }


    //update person object
    public int updatePerson(Person person){
        String sql = "UPDATE PERSON " +
                "SET NAME = ?, LOCATION = ?, BIRTHDAY = ? " +
                "WHERE ID = ?";

        return jdbcTemplate.update(sql, new Object[]{
                person.getName(),
                person.getLocation(),
                new Timestamp(person.getBirthday().getTime()), person.getId()});
    }


    class PersonRowMapper implements RowMapper<Person>{
        @Override
        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
            Person person = new Person();

            person.setId(rs.getInt("id"));
            person.setName(rs.getString("name"));
            person.setLocation(rs.getString("location"));
            person.setBirthday(rs.getTimestamp("birthday"));

            return person;
        }
    }
}
