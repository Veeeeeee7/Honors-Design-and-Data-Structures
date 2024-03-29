import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Random;

public class HashNames {

	public static void main(String[] args) {

		String[] students = {
				"Emily Ba",
				"Jonah Benadon",
				"Ben Boateng",
				"Matthew Commons",
				"Cole Grossman",
				"Phoebe Hsu",
				"Pranav Iyer",
				"Connor Kim",
				"Chance Krenzer",
				"Lucas Li",
				"Victor Li",
				"Jacob Massey",
				"Dru Reed",
				"Valeria Ruelas",
				"Sophia Schaffer",
				"Paul Song",
				"Christian Stubbeman",
				"Dylan Tsai",
				"Hugh Amshen",
				"Roen Beiley",
				"Kaito De Anda",
				"Sophia Jun",
				"Olivia Kong",
				"Bari LeBari",
				"Diego Maldonaldo",
				"Milo Messinger",
				"Taeyeon Park",
				"Ethan Seung",
				"Sky Stubbeman",
				"John Xu",
				"Helen Yang",
				"Ryan You",
				"Ahren Bhatia",
				"Asher Engelberg",
				"Markus George",
				"Gabe Graphia",
				"Chase Hameetman",
				"Allie Hunnius",
				"Alexandra Kurz",
				"Wyatt Lake",
				"Alex Lee",
				"Natalie Lim",
				"Aidan Rahill",
				"Kian Sharifi",
				"Sammy Skulsky",
				"Andrew Wesel",
				"Samantha Ahn",
				"Ryan Cheng",
				"Derek Esrailian",
				"Micah Gober",
				"Chris Headley",
				"Megan Kim",
				"Mark Ma",
				"Aidan Michaelson",
				"Aaron Moradi",
				"Will Morrison",
				"Jake Parker",
				"Ryan Pinsker",
				"Grady Ramberg",
				"Ben Ren",
				"Ronan Valle",
				"Claire Wu",
				"Sophia Zhang",
				"Kensuke Shimojo",
				"Will Sherwood",
				"Lily Saada",
				"Emma Miller",
				"Matthew Messaye",
				"Casey Landecker",
				"Andrew Jiang",
				"Grace Hudson",
				"Benjamin Ham",
				"Andrew Gutierrez",
				"Georgia Goldberg",
				"Ella Ganocy",
				"Kian Chen",
				"Iris Chen",
				"Cheery Chen",
				"William Wu",
				"Isaac Wiener",
				"Lyric Walker",
				"Evan Stokdyk",
				"Charlie Seymour",
				"Lauren LaPorta",
				"Eliza Koblentz",
				"Matthew Ko",
				"Aden Juda",
				"Bella Ganocy",
				"Aariz Furniturewala",
				"Olivia Feldman",
				"Catherine Cho",
				"Jack Austen",
				"Dylan Ardizzone",
				"Jack Burghardt",
				"Matthew Chang",
				"Claire Conner",
				"Zach Greene",
				"Elliot Lichtman",
				"Zach Rossen",
				"Graydon Schulze-Kalt",
				"Preston Shin",
				"Matthew Steiglitz",
				"Erik Steuch",
				"Daryn Wang",
				"Ava Weinrot",
				"Eric Yoon",
				"Wyatt Anand",
				"Solomon Baik",
				"Asher Burstin",
				"Naalah Cohen",
				"Konnie Duan",
				"Gavin Goldsmith",
				"Anika Iyer",
				"Steven Ko",
				"Angie Martell",
				"Idalis McZeal",
				"Jack Moreland",
				"Remy Navarre",
				"Micha Rand",
				"Asher Rossen",
				"Henry Ullendorff",
				"Sam Volokh",
				"Simon Wacziarg",
				"Jake Wiczyk",
				"Audrey Yang",
				"Grant Bishop",
				"Quinn Callaghan",
				"Lyon Chung",
				"Eli Friedman",
				"Emery Genga",
				"Sally Ho",
				"Taka Khoo",
				"Reggie Kim",
				"Skylar Liu",
				"Katie Mumford",
				"Isa Rodriguez",
				"Riley Ruiz",
				"Lukas Seklir",
				"Ryan Tsai",
				"Simran Yogakumar",
				"Lily Bailey",
				"Evelyn Choi",
				"Yvette Copeland",
				"Isaac Dienstag",
				"Maya Doyle",
				"Finn Gatins",
				"Andrew Gong",
				"Max Hahn",
				"Kyle Kaufman",
				"Kellan McCarthy",
				"Sam McLoughlin",
				"Justin Park",
				"Vishal Prashant",
				"Luke Riley",
				"Riley Tao",
				"Liam Weetman",
				"Ben Weinberg",
				"Jacky Zhang",
				"Chase Van Amburg",
				"Diego Ahmad",
				"Tammer Bagdasarian",
				"Jaden Blaser",
				"Amanda Chan",
				"Jaz Choi",
				"Whitney Elson",
				"Guy Hartstein",
				"Tyra Hirooka",
				"Coco Kaleel",
				"Jenna Kronenberg",
				"Darren Long",
				"Berry Nakash",
				"Clay Skaggs",
				"Lexi So",
				"Ashtin Wang",
				"Sabina Yampolsky",
				"Dean Barkin",
				"Stephanie Cho",
				"Pablo Greenlee",
				"Ethan Hodess",
				"Jack Hoppus",
				"Avery Keare",
				"Sofia Kim",
				"Lawrence Li",
				"Will Liu",
				"Kevin Lu",
				"Monica Martell",
				"Bryant Reese",
				"Dean Reiter",
				"Alexander Saffari",
				"Will Seymour",
				"Mitchell Thompson",
				"JP Wong",
				"David Arkow",
				"Hana Takei",
				"Warren Wang",
				"Chance Washburn",
				"Nick Witham",
				"Paige Yoo",
				"Miles Povich",
				"Mitch Burdorf",
				"Lucas Gelfond",
				"Kala Fejzo",
				"Luke Rowen",
				"Sophie Roussak",
				"Caroline Choi",
				"Uma Durairaj",
				"Jacob Lapin",
				"Joseph Kagan",
				"Ryan Wixen",
				"Emily Wesel",
				"Sara Kangaslahti",
				"Sarah Moon",
				"Vishan Chaudhary",
				"Will Daniels",
				"Charlie Ewell",
				"Rehaan Furniturewala",
				"Oliver Goldring",
				"Isabella Huang",
				"Jane Meenaghan",
				"Spencer Paul",
				"Danny Seplow",
				"Jordan Yadegar",
				"Steven Zhao",
				"Jonathan Chong",
				"Cole Heine",
				"Anthony Khaiat",
				"Kimberley Kimura",
				"Corey Marley",
				"Will Rains",
				"Jack Riley",
				"Ethan Rosen",
				"Andrew Shibuya",
				"Sarah Wilen",
				"Maclean Witmer",
				"Eli Yadidi",
				"Sidney Gathrid",
				"Will Granger",
				"Caroline Koloff",
				"Ethan Knight",
				"Pria Pant",
				"Izzy Reiff",
				"Adin Ring",
				"Jonah Ring",
				"Nathan Schoenberg",
				"Ari Sokolov",
				"Hana Takei",
				"Claire Tan",
				"Matthew Wang",
				"Chance Washburn",
				"David Ahn",
				"Daria Arzy",
				"Jordan Barkin",
				"Abner Benitez",
				"Jonathan Goldberg",
				"Zach Goldstein",
				"Shauna Hannani",
				"Warren Wang",
				"RJ Schreck",
				"Aileen Cano",
				"Jacob Cohn",
				"Jonathan Damico",
				"Marie Eric",
				"Dylan Faulcon",
				"Ellis Haker",
				"Gabe Kaplan",
				"Timothy Kihiczak",
				"Nicole Kim",
				"Xander Klein",
				"Marcus Leher",
				"Keller Maloney",
				"Pierce Maloney",
				"Alec Mendelsohn",
				"Jonty Nobbs",
				"Paul Rodriguez",
				"Tiber Seireeni",
				"Nick Settelmayer",
				"Pavan Tauh",
				"Dieter Cortez",
				"Howard Deshong",
				"Jacob Frank",
				"Oliver Friedman",
				"Troy Hattler",
				"Robert Heckerman",
				"Matt Henriks",
				"Odin Hernandez",
				"Matt Hogan",
				"James Kanoff",
				"Carmen Levine",
				"Micah Maccoby",
				"Catrin Murphy",
				"Brendan Rose",
				"Justin Rose",
				"Eli Goldin",
				"Lara Bagdasarian",
				"Jonny Berman",
				"Collin Shannon",
				"Keaton Tam",
				"Bryant Wu",
				"Ethan Blaser",
				"Jason Chang",
				"Anthony Cho",
				"Casey Crosson",
				"Serena Davis",
				"Ravi Durairaj",
				"Andrew Gaut",
				"Justin Golden",
				"Eric Han",
				"Anthony Kukavica",
				"Tony Ma",
				"Quentin McKenzie",
				"Rohan Prashant",
				"Nomi Ringach",
				"Rachel Seplow",
				"Cameron Shaw",
				"Quinton Simmonds",
				"Nick Sweeney",
				"David Wagner",
				"James Xu",
				"Nina Milligan",
				"Eddie Mack",
				"Katie Speare",
				"Jake Zimmer",
				"Jaden Bobb",
				"Sarah Brown",
				"David Chen",
				"Joshua Cheng",
				"Luke Collins",
				"Arden Doyle",
				"Jingjing Duan",
				"Audrey Engman",
				"Oren Hartstein",
				"Daniel Hernandez",
				"Sabrina Liu",
				"Ari Meron",
				"Elysia Phillips",
				"Sam Pulaski",
				"Chris Robertson",
				"Wyatt Van Amburg",
				"Olivia Wang",
				"Jack Welsh",
				"Chris Weng",
				"Karen Wu"
		};
		System.out.println(students.length);
		for (int hashTableSize = 20; hashTableSize < 1000; hashTableSize *= 2) {
			int collisions = 0;
			int[] chainLengths = new int[hashTableSize];
			int maxChainLength = 0;
			int emptyBuckets = hashTableSize;
			for (String student : students) {
				int index = (myHash(student) & 0x7FFFFFFF) % hashTableSize;
				if (chainLengths[index] != 0) {
					collisions++;
				} else
					emptyBuckets--;

				chainLengths[index]++;
				if (chainLengths[index] > maxChainLength)
					maxChainLength = chainLengths[index];

			}

			float usedProportion = ((float) (hashTableSize - emptyBuckets)) / ((float) hashTableSize);

			System.out.println("For hash table size (number of buckets) = " + hashTableSize + ":");
			System.out.println("Total collisions: " + collisions);
			System.out.println("Proportion of collisions: " + ((float) collisions) / ((float) students.length));
			System.out.println("Max chain length: " + maxChainLength);
			System.out.println("Proportion of used buckets: " + usedProportion);
			System.out.println();
		}

	}

	private static int myHash(String s) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			byte[] messageDigest = md.digest(s.getBytes());
			BigInteger no = new BigInteger(1, messageDigest);
			return Integer.valueOf(no.intValue());
			// return Integer.decode(no.toString(10).substring(0, 9));
			// String hashtext = no.toString(16);

			// while (hashtext.length() < 40) {
			// hashtext = "0" + hashtext;
			// }
			// return Integer.parseInt(hashtext);
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
		// Make up your own hash function!
	}
}
