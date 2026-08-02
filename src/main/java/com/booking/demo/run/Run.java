package com.booking.demo.run;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
@AllArgsConstructor
@Data
public class Run {
Integer id;
String title;
LocalDateTime StartedOn;
LocalDateTime CompletedOn;
Integer miles;
Location Location;
}
