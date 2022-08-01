package com.cg.search.model;

import java.util.List;

	public class ListFlight {
		private List<Flight> var;

		public ListFlight() {

		}

		public ListFlight(List<Flight> var) {
			super();
			this.var = var;
		}

		public List<Flight> getVar() {
			return var;
		}

		public void setVar(List<Flight> var) {
			this.var = var;
		}

		@Override
		public String toString() {
			return "ListFLights [var=" + var + "]";
		}

	}



