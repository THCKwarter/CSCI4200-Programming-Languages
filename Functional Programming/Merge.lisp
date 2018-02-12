(print "1.4 Merge Names - CSCI4200 - Matthew Johnston")
(print "#############################################")

;;; Get first names from user and create list
(format t "~%(1/4) Enter a first name: ") 
(defvar name1 (read))
(format t "~%(2/4) Enter a first name: ")
(defvar name2 (read))
(format t "~%(3/4) Enter a first name: ")
(defvar name3 (read))
(format t "~%(4/4) Enter a first name: ")
(defvar name4 (read))

(defvar firstNames(list name1 name2 name3 name4))

;;; Get last names from user and create list
(format t "~%(1/4) Enter a last name: ")
(defvar name5 (read))
(format t "~%(2/4) Enter a last name: ")
(defvar name6 (read))
(format t "~%(3/4) Enter a last name: ")
(defvar name7 (read))
(format t "~%(4/4) Enter a last name: ")
(defvar name8 (read))

(defvar lastNames(list name5 name6 name7 name8))

;;; Merge first and last names into one list
(defvar fName1(list(nth 0 firstNames) (nth 0 lastNames)))
(defvar fName2(list(nth 1 firstNames) (nth 1 lastNames)))
(defvar fName3(list(nth 2 firstNames) (nth 2 lastNames)))
(defvar fName4(list(nth 3 firstNames) (nth 3 lastNames)))
(defvar fullNames(list fName1 fName2 fName3 fName4))

;;; Output name lists
(format t "~%First names: ~a" firstNames)
(format t "~%Last names: ~a" lastNames)
(format t "~%Full names: ~a" fullNames)