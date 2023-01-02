package assignment2;

/*
Matriculation Number -  Name
 761318      : Bishal Karki
 */

public class Playlist {

	private Node head = null, tail = null;
	int size =0;


	public Node getHead() {
	    return head;
	  }

	  public void setHead(Node head) {
	    this.head = head;
	  }

	public Node getTail() {
		return this.tail;
	}


	public void firstNode(Node node) {
		head = node;
		tail = node;
		head.setPrevious(null);
		tail.setNext(null);

	}
	public void lastNode(Node node) {
		tail.setNext(node);
		node.setPrevious(tail);
		tail = node;
		tail.setNext(null);
	}

	public void addNodeInBeginning(Node node) {
		head.setPrevious(node);
		node.setNext(head);
		node.setPrevious(null);
		head = node;
	}

	public boolean contains(Song data) {
        Node current = head;
        while (current != null) {
            if (current.getData().equals(data)) {
                return true;
            }
            current = current.getNext();
        }

        return false;
    }

	public boolean add(Song data){
		if (contains(data)) {
			return false;
		}
		Node newNode = new Node(data);
		if (head == null){
		     firstNode(newNode);
		     }
		else {
			lastNode(newNode);
		}
		size ++;
			return true;
		     }



	   public boolean moveTo(Song data, int index) {
	        Node current = head;
	        while (current != null) {
	            if (current.getData().equals(data)) {
	                break;
	            }
	            current = current.getNext();
	        }
	        if (current == null) {
	        	System.out.println("The song is not in playlist");
	            return false;
	        }

	        if (current == head) {
	            head = current.getNext();
	            if (head != null) {
	                head.setPrevious(null);
	            }
	        } else if (current == tail) {
	            tail = current.getPrevious();
	            tail.setNext(null);
	        } else {
	            current.getPrevious().setNext(current.getNext());
	            current.getNext().setPrevious(current.getPrevious());
	        }


	        if (index == 0) {
	            current.setNext(head);
	            current.setPrevious(null);
	            head.setPrevious(current);
	            head = current;
	        }else if (index >= size ){
	        	lastNode(current);
	        }
	        else {
	            Node insertAfter = head;
	            for (int j = 0; j < index - 1; j++) {
	                insertAfter = insertAfter.getNext();
	            }
	            current.setPrevious(insertAfter);
	            current.setNext(insertAfter.getNext());
	            insertAfter.getNext().setPrevious(current);
	            insertAfter.setNext(current);
	            if (insertAfter == tail) {

	                tail = current;
	            }
	        }
	        return true;
	        }

	   public boolean deleteNodeAt(int index) {
		   if (getHead() == null) return false;
		   if(getHead() == getTail()) {
			   head = null;
			   tail = null;
			   return true;
		   }
		   if(index == 1) {
			   Node currentNode = getHead();
			   head = currentNode.getNext();
			   head.setPrevious(null);
			   currentNode= null;
			   return true;
		   }
		   Node currentNode = getHead();
		   while(index > 1 && currentNode != null) {
			   currentNode = currentNode.getNext();
			   index --;
		   }
		   if(index < 1 || currentNode == null) return false;
		   if(currentNode == getTail()) {
			   Node previousNode = currentNode.getPrevious();
			   previousNode.setNext(null);
			   currentNode = null;
			   tail = previousNode;
			   return true;
			}

		   Node previousNode = currentNode.getPrevious();
		   Node nextNode = currentNode.getNext();
		   previousNode.setNext(nextNode);
		   nextNode.setPrevious(previousNode);
		   currentNode = null;
		   return true;
	   }


		public  Playlist sortByRank(Playlist dataSongs) {
			Playlist sortedPlaylist = new Playlist();
			Node current = head;
			while (current != null) {
			  Node next = current.getNext();
			  sortedPlaylist.insertSorted(current);
			  current = next;
			}
			return sortedPlaylist;
		}

		private void insertSorted(Node newNode) {
			if (head == null || head.getData().getRanking() > newNode.getData().getRanking()) {
			  newNode.setNext(head);
			  if (head != null) {
				head.setPrevious(newNode);
			  }
			  head = newNode;
			  return;
			}
			Node current = head;
			while (current.getNext() != null && current.getNext().getData().getRanking() <= newNode.getData().getRanking()) {
			  current = current.getNext();
			}
			newNode.setNext(current.getNext());
			if (current.getNext() != null) {
			  current.getNext().setPrevious(newNode);
			}
			current.setNext(newNode);
			newNode.setPrevious(current);
		  }

		public  Playlist appendList(Playlist firstPlaylist, Playlist secondPlaylist) {
			if(firstPlaylist.getHead() == null && secondPlaylist.getHead() == null) return null;

			if (firstPlaylist.getHead() == null) {
				firstPlaylist = secondPlaylist;
				secondPlaylist = null;
				return firstPlaylist;
			}

			else {
				if(secondPlaylist.getHead() != null) {
					firstPlaylist.getTail().setNext(secondPlaylist.getHead());
					secondPlaylist = null;
				}
			}

			return firstPlaylist;
		}


		public Playlist frontBackSplit(Playlist list) {
		    Playlist BlackList = new Playlist();
		    int size = getSize(list);
		    Node current = list.getHead();
		    for (int i = 0; i < size / 2; i++) {
		        current = current.getNext();
		    }
		    BlackList.setHead(current);
		    return BlackList;
		}

		private int getSize(Playlist list) {
		    int size = 0;
		    Node current = list.getHead();
		    while (current != null) {
		        size++;
		        current = current.getNext();
		    }
		    return size;
		}


		 public Playlist alternatingSplit(Playlist list1) {
		        Playlist result = new Playlist();
		        Node current = list1.getHead();
		        int index = 1;
		        while (current != null) {
		        	index++;
		        	current = current.getNext();
		            if (index >= 2 && current != null) {
		                result.add(current.getData());
		                list1.deleteNodeAt(index);
		                current = current.getNext();
		            }
		        }

		        return result;
		    }

		  public Playlist shuffleMerge(Playlist list1, Playlist list2 ) {
		        Playlist result = new Playlist();
		        Node current1 = list1.getHead();
		        Node current2 = list2.getHead();
		        while (current1 != null || current2 != null) {
		            if (current1 != null) {
		                result.add(current1.getData());
		                current1 = current1.getNext();
		            }
		            if (current2 != null) {
		                result.add(current2.getData());
		                current2 = current2.getNext();
		            }
		        }
		        list1 = result;
		        list2 = null;
		        return list1;
		    }


		     //print
		     public void printList(){
		        if (head == null){
		            System.out.println("List is empty");
		            return;
		        }
		        Node currNode = getHead();
		        System.out.println("Nodes of doubly link list");
		        while(currNode != null){
		        	Song song = currNode.getData();
		            System.out.println("Title = "+ song.getTitle() + ", Artist = "+ song.getArtist() + ", ranking = " + song.getRanking());
		        	currNode = currNode.getNext();
		        }

		     }

	}

