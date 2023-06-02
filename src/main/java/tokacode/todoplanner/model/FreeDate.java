package tokacode.todoplanner.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class FreeDate {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		private LocalDate freedate;
		private int freehours;
		
		public FreeDate() {
		}

		public FreeDate(LocalDate freedate, int freehours) {
			this.freedate = freedate;
			this.freehours = freehours;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public LocalDate getFreedate() {
			return freedate;
		}

		public void setFreedate(LocalDate freedate) {
			this.freedate = freedate;
		}

		public int getFreehours() {
			return freehours;
		}

		public void setFreehours(int freehours) {
			this.freehours = freehours;
		}
		
		
		
		
		
}
