package com.booking.demo.run;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDateTime;


@AllArgsConstructor
@Data
public class Run {
Integer id;
@NotEmpty
String title;
LocalDateTime StartedOn;
LocalDateTime CompletedOn;
@Positive
Integer miles;
Location Location;
}
