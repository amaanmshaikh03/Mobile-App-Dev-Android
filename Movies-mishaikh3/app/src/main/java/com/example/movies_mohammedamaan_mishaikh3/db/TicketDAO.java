package com.example.movies_mohammedamaan_mishaikh3.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.movies_mohammedamaan_mishaikh3.models.ticket;

import java.util.List;

@Dao
public interface TicketDAO {

    // insert
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void insertTicket(ticket emp);

    // retrieve data
    @Query("SELECT * FROM ticket_table")
    public List<ticket> getAllTickets();

    // retrieve ONE employee
    @Query("SELECT * FROM ticket_table WHERE id = :empId")
    public ticket getTicketById(int empId);

    // delete or update an employee
    @Update
    public void updateTicket(ticket employeeToUpdate);

    @Delete
    public void deleteTicket(ticket employeeToDelete);

}

