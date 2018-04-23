
package calculator;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import calculator.BusinessLogic;

/**
 * <p> Title: UserInterface Class. </p>
 * 
 * <p> Description: The Java/FX-based user interface for the calculator. The class works with String
 * objects and passes work to other classes to deal with all other aspects of the computation.</p>
 * 
 * <p> Copyright:Sahaskiran  © 2017 </p>
 * 
 * @authorSahaskiran 
 * 
 * @version 4.00	2017-10-17 The JavaFX-based GUI for the implementation of a calculator
 * 
 */

public class UserInterface {
	
	/**********************************************************************************************

	Attributes
	
	**********************************************************************************************/
	
	/* Constants used to parameterize the graphical user interface.  We do not use a layout manager for
	   this application. Rather we manually control the location of each graphical element for exact
	   control of the look and feel. */
	private final double BUTTON_WIDTH = 60;
	private final double BUTTON_OFFSET = BUTTON_WIDTH/2;

	// These are the application values required by the user interface
		private Label label_DoubleCalculator = new Label(" Double Calculator"+"With"+"Error term");
		private Label label_Operand1 = new Label("First operand");
		private TextField text_Operand1 = new TextField();
		private Label label_Operand3 = new Label("Error Term");
		private TextField text_Operand3 = new TextField();
		private Label label_Operand2 = new Label("Second operand");
		private TextField text_Operand2 = new TextField();
		private Label label_Operand4 = new Label("Error Term");
		private TextField text_Operand4 = new TextField();
		private Label label_Result = new Label("Result");
		private TextField text_Result = new TextField();
		private Label label_Resulterr = new Label("Error Term");
		private TextField text_Resulterr = new TextField();
		private Label label_variable = new Label("\u00B1");
		private Label label_variable1 = new Label("\u00B1");
		private Label label_variable2 = new Label("\u00B1");
		private Button button_Add = new Button("+");
		private Button button_Sub = new Button("-");
		private Button button_Mpy = new Button("\u00D7");				// The multiply symbol: \u00D7
		private Button button_Div = new Button("\u00F7");				// The divide symbol: \u00F7
		private Button button_Sqrt = new Button("\u221A");              // The root symbol: \u221A
		private Label label_errOperand1 = new Label("");                // Label to display specific
		private Label label_errOperand2 = new Label("");                // error messages
		private Label label_errOperand3 = new Label("");                // Label to display specific
		private Label label_errOperand4 = new Label("");
		private Label label_errOperand1One = new Label("");               // Label to display a error message
		private Label label_errOperand2Two = new Label("");	            // when user tries to perform any function
		private Label label_errOperand3three = new Label("");               // Label to display a error message
		private Label label_errOperand4four = new Label("");
		private Label label_errResult = new Label("");
		private Label label_errResulterr = new Label("");
		private TextFlow err1;
	    private Text operand1ErrPart1 = new Text();
	    private Text operand1ErrPart2 = new Text();
	    private TextFlow err2;
	    private Text operand2ErrPart1 = new Text();
	    private Text operand2ErrPart2 = new Text();
	    private TextFlow err3;
	    private Text operand3ErrPart1 = new Text();
	    private Text operand3ErrPart2 = new Text();
	    private TextFlow err4;
	    private Text operand4ErrPart1 = new Text();
	    private Text operand4ErrPart2 = new Text();


		// If the multiplication and/or division symbols do not display properly, replace the
		// quoted strings used in the new Button constructor call with the <backslash>u00xx values
		// shown on the same line. This is the Unicode representation of those characters and will
		// work regardless of the underlying hardware being used.

		private double buttonSpace;
		                                // This is the white space between the operator buttons.

		/* This is the link to the business logic */
		public BusinessLogic perform = new BusinessLogic();


		/**********************************************************************************************

		Constructors

		**********************************************************************************************/

		/**********
		 * This method initializes all of the elements of the graphical user interface. These assignments
		 * determine the location, size, font, color, and change and event handlers for each GUI object.
		 */



		public UserInterface(Pane theRoot) {

			// There are five gaps. Compute the button space accordingly.
			buttonSpace = Calculator.WINDOW_WIDTH / 5;

			// Label theScene with the name of the calculator, centered at the top of the pane
			setupLabelUI(label_DoubleCalculator, "Arial", 24, Calculator.WINDOW_WIDTH, Pos.CENTER, 100, 10);

			// Label the first operand just above it, left aligned
			setupLabelUI(label_Operand1, "Arial", 18, Calculator.WINDOW_WIDTH-10, Pos.BASELINE_LEFT, 10, 40);

			// Establish the first text input operand field and when anything changes in operand 1,
			// process both fields to ensure that we are ready to perform as soon as possible.
			setupTextUI(text_Operand1, "Arial", 18, Calculator.WINDOW_WIDTH-450, Pos.BASELINE_LEFT, 10, 70, true);
			text_Operand1.textProperty().addListener((observable, oldValue, newValue) -> {setOperand1(); });
			// Move focus to the second operand when the user presses the enter (return) key
			text_Operand1.setOnAction((event) -> { text_Operand3.requestFocus(); });

			// Establish an error message for the first operand just above it with, left aligned
			setupLabelUI(label_errOperand1One, "Arial", 18, Calculator.WINDOW_WIDTH-10, Pos.BASELINE_LEFT, 400, 45);
			label_errOperand1One.setTextFill(Color.RED);

			//Bottom proper error message
			label_errOperand1.setTextFill(Color.RED);
			label_errOperand1.setAlignment(Pos.BASELINE_LEFT);
			setupLabelUI(label_errOperand1, "Arial", 14, Calculator.WINDOW_WIDTH, Pos.BASELINE_LEFT, 22, 128);


			setupLabelUI(label_variable, "Arial", 18, Calculator.WINDOW_WIDTH-10, Pos.BASELINE_LEFT, 375, 75);



			// Label the Third operand just above it, left aligned
			setupLabelUI(label_Operand3, "Arial", 18, Calculator.WINDOW_WIDTH-10, Pos.BASELINE_LEFT, 400, 40);

			// Establish the Third text input operand field and when anything changes in operand 3,
			// process both fields to ensure that we are ready to perform as soon as possible.
			setupTextUI(text_Operand3, "Arial", 18, Calculator.WINDOW_WIDTH-450, Pos.BASELINE_LEFT, 400, 70, true);
			text_Operand3.textProperty().addListener((observable, oldValue, newValue) -> {setOperand3(); });
			// Move focus to the Third operand when the user presses the enter (return) key
			text_Operand3.setOnAction((event) -> { text_Operand2.requestFocus(); });

			// Establish an error message for the Third operand just above it with, left aligned
			setupLabelUI(label_errOperand3three, "Arial", 18, Calculator.WINDOW_WIDTH-10, Pos.BASELINE_RIGHT, 400, 45);
			label_errOperand3three.setTextFill(Color.RED);

			//Bottom proper error message
			label_errOperand3.setTextFill(Color.RED);
			label_errOperand3.setAlignment(Pos.BASELINE_RIGHT);
			setupLabelUI(label_errOperand3, "Arial", 14, Calculator.WINDOW_WIDTH-100-10, Pos.BASELINE_LEFT, 400, 128);










			// Label the second operand just above it, left aligned
			setupLabelUI(label_Operand2, "Arial", 18, Calculator.WINDOW_WIDTH-10, Pos.BASELINE_LEFT, 10, 155);

			// Establish the second text input operand field and when anything changes in operand 2,
			// process both fields to ensure that we are ready to perform as soon as possible.
			setupTextUI(text_Operand2, "Arial", 18, Calculator.WINDOW_WIDTH-450, Pos.BASELINE_LEFT, 10, 180, true);
			text_Operand2.textProperty().addListener((observable, oldValue, newValue) -> {setOperand2(); });

			// Move the focus to the result when the user presses the enter (return) key
			text_Operand2.setOnAction((event) -> { text_Operand4.requestFocus(); });

			// Establish an error message for the second operand just above it with, left aligned
			setupLabelUI(label_errOperand2Two, "Arial", 18, Calculator.WINDOW_WIDTH-10, Pos.BASELINE_LEFT, 400, 155);
			label_errOperand2Two.setTextFill(Color.RED);

			//Bottom proper error message
			label_errOperand2.setTextFill(Color.RED);
			label_errOperand2.setAlignment(Pos.BASELINE_RIGHT);
			setupLabelUI(label_errOperand2, "Arial", 14, Calculator.WINDOW_WIDTH-150-10, Pos.BASELINE_LEFT, 22, 233);
			label_errOperand2.setTextFill(Color.RED);



			setupLabelUI(label_variable1, "Arial", 18, Calculator.WINDOW_WIDTH-10, Pos.BASELINE_LEFT, 375, 190);




			// Label the Fourth operand just above it, left aligned
					setupLabelUI(label_Operand4, "Arial", 18, Calculator.WINDOW_WIDTH-10, Pos.BASELINE_LEFT, 400, 155);

					// Establish the Fourth text input operand field and when anything changes in operand 4,
					// process both fields to ensure that we are ready to perform as soon as possible.
					setupTextUI(text_Operand4, "Arial", 18, Calculator.WINDOW_WIDTH-450, Pos.BASELINE_LEFT, 400, 180, true);
					text_Operand4.textProperty().addListener((observable, oldValue, newValue) -> {setOperand4(); });



					// Establish an error message for the Fourth operand just above it with, left aligned
					setupLabelUI(label_errOperand4four, "Arial", 18, Calculator.WINDOW_WIDTH-10, Pos.BASELINE_LEFT, 400, 155);
					label_errOperand4four.setTextFill(Color.RED);

					//Bottom proper error message
					label_errOperand4.setTextFill(Color.RED);
					label_errOperand4.setAlignment(Pos.BASELINE_RIGHT);
					setupLabelUI(label_errOperand4, "Arial", 14, Calculator.WINDOW_WIDTH-150-10, Pos.BASELINE_LEFT, 400, 233);
					label_errOperand4.setTextFill(Color.RED);

















			// Label the result just above the result output field, left aligned
			setupLabelUI(label_Result, "Arial", 18, Calculator.WINDOW_WIDTH-10, Pos.BASELINE_LEFT, 10, 260);

			// Establish the result output field.  It is not editable, so the text can be selected and copied,
			// but it cannot be altered by the user.  The text is left aligned.
			setupTextUI(text_Result, "Arial", 18, Calculator.WINDOW_WIDTH-450, Pos.BASELINE_LEFT, 10, 290, false);

			// Establish an error message for the Result operand just above it with, right aligned

			setupLabelUI(label_errResult, "Arial", 18, Calculator.WINDOW_WIDTH-10, Pos.BASELINE_LEFT, 30,230);
			label_errResult.setTextFill(Color.RED);

			setupLabelUI(label_variable2, "Arial", 18, Calculator.WINDOW_WIDTH-10, Pos.BASELINE_LEFT, 375, 300);


			// Label the result just above the result output field, left aligned
					setupLabelUI(label_Resulterr, "Arial", 18, Calculator.WINDOW_WIDTH-10, Pos.BASELINE_LEFT, 400, 260);

					// Establish the result output field.  It is not editable, so the text can be selected and copied,
					// but it cannot be altered by the user.  The text is left aligned.
					setupTextUI(text_Resulterr, "Arial", 18, Calculator.WINDOW_WIDTH-450, Pos.BASELINE_LEFT, 400, 290, false);

					// Establish an error message for the Result operand just above it with, right aligned

					setupLabelUI(label_errResulterr, "Arial", 18, Calculator.WINDOW_WIDTH-10, Pos.BASELINE_LEFT, 400,220);
					label_errResulterr.setTextFill(Color.RED);






			// Establish the ADD "+" button, position it, and link it to methods to accomplish its work
			setupButtonUI(button_Add, "Symbol", 32, BUTTON_WIDTH, Pos.BASELINE_LEFT, 0.5 * buttonSpace-BUTTON_OFFSET, 350);
			button_Add.setOnAction((event) -> { addOperands(); addOperands1(); });


			// Establish the SUB "-" button, position it, and link it to methods to accomplish its work
			setupButtonUI(button_Sub, "Symbol", 32, BUTTON_WIDTH, Pos.BASELINE_LEFT, 1.5 * buttonSpace-BUTTON_OFFSET, 350);
			button_Sub.setOnAction((event) -> { subOperands(); subOperands1(); });

			// Establish the MPY "x" button, position it, and link it to methods to accomplish its work
			setupButtonUI(button_Mpy, "Symbol", 32, BUTTON_WIDTH, Pos.BASELINE_LEFT, 2.5 * buttonSpace-BUTTON_OFFSET, 350);
			button_Mpy.setOnAction((event) -> { mpyOperands(); mpyOperands1(); });

			// Establish the DIV "/" button, position it, and link it to methods to accomplish its work
			setupButtonUI(button_Div, "Symbol", 32, BUTTON_WIDTH, Pos.BASELINE_LEFT, 3.5 * buttonSpace-BUTTON_OFFSET, 350);
			button_Div.setOnAction((event) -> { divOperands(); divOperands1(); });

			// Establish the SQRT "root" button, position it, and link it to methods to accomplish its work
			setupButtonUI(button_Sqrt, "Symbol", 32, BUTTON_WIDTH, Pos.BASELINE_LEFT, 4.5 * buttonSpace-BUTTON_OFFSET, 350);
			button_Sqrt.setOnAction((event) -> { sqrtOperands(); sqrtOperands1(); });


			// Error Message for the Measured Value for operand 1
					operand1ErrPart1.setFill(Color.BLACK);
				    operand1ErrPart1.setFont(Font.font("Arial", FontPosture.REGULAR, 18));
				    operand1ErrPart2.setFill(Color.RED);
				    operand1ErrPart2.setFont(Font.font("Arial", FontPosture.REGULAR, 24));
				    err1 = new TextFlow(operand1ErrPart1, operand1ErrPart2);
					err1.setMinWidth(Calculator.WINDOW_WIDTH-10);
					err1.setLayoutX(22);
					err1.setLayoutY(100);

			// Error Message for the Measured Value for operand 2
					operand2ErrPart1.setFill(Color.BLACK);
				    operand2ErrPart1.setFont(Font.font("Arial", FontPosture.REGULAR, 18));
				    operand2ErrPart2.setFill(Color.RED);
				    operand2ErrPart2.setFont(Font.font("Arial", FontPosture.REGULAR, 24));
				    err2 = new TextFlow(operand2ErrPart1, operand2ErrPart2);
					err2.setMinWidth(Calculator.WINDOW_WIDTH-10);
					err2.setLayoutX(22);
					err2.setLayoutY(210);

					// Error Message for the Measured Value for operand 3
					operand3ErrPart1.setFill(Color.BLACK);
				    operand3ErrPart1.setFont(Font.font("Arial", FontPosture.REGULAR, 18));
				    operand3ErrPart2.setFill(Color.RED);
				    operand3ErrPart2.setFont(Font.font("Arial", FontPosture.REGULAR, 24));
				    err3 = new TextFlow(operand3ErrPart1, operand3ErrPart2);
					err3.setMinWidth(Calculator.WINDOW_WIDTH-10);
					err3.setLayoutX(410);
					err3.setLayoutY(100);


					// Error Message for the Measured Value for operand 4
					operand4ErrPart1.setFill(Color.BLACK);
				    operand4ErrPart1.setFont(Font.font("Arial", FontPosture.REGULAR, 18));
				    operand4ErrPart2.setFill(Color.RED);
				    operand4ErrPart2.setFont(Font.font("Arial", FontPosture.REGULAR, 24));
				    err4 = new TextFlow(operand4ErrPart1, operand4ErrPart2);
					err4.setMinWidth(Calculator.WINDOW_WIDTH-10);
					err4.setLayoutX(410);
					err4.setLayoutY(210);

			// Place all of the just-initialized GUI elements into the pane
			theRoot.getChildren().addAll(label_DoubleCalculator, label_variable, label_variable1, label_variable2, label_Operand1, text_Operand1, label_errOperand1,
				label_Operand2, text_Operand2, label_errOperand2, label_Operand3, text_Operand3, label_errOperand3, label_Operand4, text_Operand4, label_errOperand4,
				label_Result, text_Result, label_errResult, label_Resulterr, text_Resulterr, label_errResulterr, button_Add, button_Sub, button_Mpy, button_Div, button_Sqrt, err1, err2, err3, err4,  label_errOperand1One,
					label_errOperand2Two, label_errOperand3three, label_errOperand4four);

		}

		/*******
		 * This public methods invokes the methods of Calculator class and generate a specific error
		 * message when the user enters the value of operand1
		 *
		 */
		public void mv() {
			String errMessage = CalculatorValue.checkMeasureValue(text_Operand1.getText());
			if (errMessage != "") {
				label_errOperand1.setText(CalculatorValue.measuredValueErrorMessage);
				if (CalculatorValue.measuredValueIndexofError <= -1) return;
				String input = CalculatorValue.measuredValueInput;
				operand1ErrPart1.setText(input.substring(0, CalculatorValue.measuredValueIndexofError));
				operand1ErrPart2.setText("\u21EB");
			}
		}

		/*******
		 * This public methods invokes the methods of Calculator class and generate a specific error
		 * message when the user enters the value of operand2
		 *
		 */
		public void et() {
			String errMessage = CalculatorValue.checkMeasureValue(text_Operand2.getText());
			if (errMessage != "") {
				label_errOperand2.setText(CalculatorValue.measuredValueErrorMessage);
				if (CalculatorValue.measuredValueIndexofError <= -1) return;
				String input = CalculatorValue.measuredValueInput;
				operand2ErrPart1.setText(input.substring(0, CalculatorValue.measuredValueIndexofError));
				operand2ErrPart2.setText("\u21EB");
			}
		}

		/*******
		 * This public methods invokes the methods of Calculator class and generate a specific error
		 * message when the user enters the value of operand2
		 *
		 */



		private void as() {
			String errMessage = CalculatorValue.checkMeasureValue(text_Operand3.getText());
			if (errMessage != "") {
				System.out.println(errMessage);
				label_errOperand3.setText(CalculatorValue.measuredValueErrorMessage);
				if (CalculatorValue.measuredValueIndexofError <= -1) return;
				String input = CalculatorValue.measuredValueInput;
				operand3ErrPart1.setText(input.substring(0, CalculatorValue.measuredValueIndexofError));
				operand3ErrPart2.setText("\u21EB");
			}
			else {
				errMessage = CalculatorValue.checkErrorTerm(text_Operand3.getText());
				if (errMessage != "") {
					System.out.println(errMessage);
					label_errOperand3.setText(CalculatorValue.errorTermErrorMessage);
					String input = CalculatorValue.errorTermInput;
				if (CalculatorValue.errorTermIndexofError <= -1) return;
					operand3ErrPart1.setText(input.substring(0, CalculatorValue.errorTermIndexofError));
					operand3ErrPart2.setText("\u21EB");
				}}}

		/*******
		 * This public methods invokes the methods of Calculator class and generate a specific error
		 * message when the user enters the value of operand2
		 *
		 */


		private void at() {
			String errMessage = CalculatorValue.checkMeasureValue(text_Operand4.getText());
			if (errMessage != "") {
				System.out.println(errMessage);
				label_errOperand4.setText(CalculatorValue.measuredValueErrorMessage);
				if (CalculatorValue.measuredValueIndexofError <= -1) return;
				String input = CalculatorValue.measuredValueInput;
				operand4ErrPart1.setText(input.substring(0, CalculatorValue.measuredValueIndexofError));
				operand4ErrPart2.setText("\u21EB");
			}
			else {
				errMessage = CalculatorValue.checkErrorTerm(text_Operand4.getText());
				if (errMessage != "") {
					System.out.println(errMessage);
					label_errOperand4.setText(CalculatorValue.errorTermErrorMessage);
					String input = CalculatorValue.errorTermInput;
				if (CalculatorValue.errorTermIndexofError <= -1) return;
					operand4ErrPart1.setText(input.substring(0, CalculatorValue.errorTermIndexofError));
					operand4ErrPart2.setText("\u21EB");
				}}}

		/**********
		 * Private local method to initialize the standard fields for a label
		 */
		private void setupLabelUI(Label l, String ff, double f, double w, Pos p, double x, double y){
			l.setFont(Font.font(ff, f));
			l.setMinWidth(w);
			l.setAlignment(p);
			l.setLayoutX(x);
			l.setLayoutY(y);
		}

		/**********
		 * Private local method to initialize the standard fields for a text field
		 */
		private void setupTextUI(TextField t, String ff, double f, double w, Pos p, double x, double y, boolean e){
			t.setFont(Font.font(ff, f));
			t.setMinWidth(w);
			t.setMaxWidth(w);
			t.setAlignment(p);
			t.setLayoutX(x);
			t.setLayoutY(y);
			t.setEditable(e);
		}

		/**********
		 * Private local method to initialize the standard fields for a button
		 */
		private void setupButtonUI(Button b, String ff, double f, double w, Pos p, double x, double y){
			b.setFont(Font.font(ff, f));
			b.setMinWidth(w);
			b.setAlignment(p);
			b.setLayoutX(x);
			b.setLayoutY(y);
		}


		/**********************************************************************************************

		User Interface Actions

		**********************************************************************************************/

		/**********
		 * Private local method to set the value of the first operand given a text value. The method uses the
		 * business logic class to perform the work of checking the string to see it is a valid value and if
		 * so, saving that value internally for future computations. If there is an error when trying to convert
		 * the string into a value, the called business logic method returns false and actions are taken to
		 * display the error message appropriately.
		 */
		private void setOperand1() {
			text_Result.setText("");									// Any change of an operand probably invalidates
			label_Result.setText("Result");								// the result, so we clear the old result.
			label_errResult.setText("");
			if (perform.setOperand1(text_Operand1.getText())) {			// Set the operand and see if there was an error
				label_errOperand1.setText("");							// If no error, clear this operands error
				label_errOperand1One.setText("");
				operand1ErrPart1.setText("");                   		// Clear the first term of error part
				operand1ErrPart2.setText("");                   		// Clear the second term of error part
				if (text_Operand2.getText().length() == 0)				// If the other operand is empty, clear its error
					label_errOperand2.setText("");						// as well.
			}
			else 														// If there's a problem with the operand, display
				mv();
		}


		/**********
		 * Private local method to set the value of the second operand given a text value. The logic is exactly the
		 * same as used for the first operand, above.
		 */
		private void setOperand2() {
			text_Result.setText("");
			label_Result.setText("Result");
			label_errResult.setText("");
			if (perform.setOperand2(text_Operand2.getText())) {
				label_errOperand2.setText("");
				label_errOperand2Two.setText("");
				operand2ErrPart1.setText("");                   		// Clear the first term of error part
				operand2ErrPart2.setText("");                  			// Clear the second term of error part
				if (text_Operand1.getText().length() == 0)
					label_errOperand1.setText("");
			}
			else
				et();
		}



		private void setOperand3() {
			label_errOperand3.setText("");
			operand3ErrPart1.setText("");
			operand3ErrPart2.setText("");
			if (perform.setOperand3(text_Operand3.getText())) {
			text_Resulterr.setText("");									// Any change of an operand probably invalidates
			label_Resulterr.setText("Error Term");					   // the result, so we clear the old result.
			label_errResulterr.setText("");		                      // Set the operand and see if there was an error
				label_errOperand3.setText("");}						 // If no error, clear this operands error

				if (text_Operand4.getText().length() == 0)				// If the other operand is empty, clear its error
					label_errOperand4.setText("");						// as well.

			as();
			}


		private void setOperand4() {
			label_errOperand4.setText("");
			operand4ErrPart1.setText("");
			operand4ErrPart2.setText("");
			if (perform.setOperand4(text_Operand4.getText())) {
			text_Resulterr.setText("");									// Any change of an operand probably invalidates
			label_Resulterr.setText("Error Term");								// the result, so we clear the old result.
			label_errResulterr.setText("");		                      // Set the operand and see if there was an error
				label_errOperand3.setText("");}							// If no error, clear this operands error

				if (text_Operand3.getText().length() == 0)				// If the other operand is empty, clear its error
					label_errOperand3.setText("");						// as well.

			at();
			}







		/**********
		 * Private local method to set the value of the first operand given a text value. The method uses the
		 * business logic class to perform the work of checking the string to see it is a valid value and if
		 * so, saving that value internally for future computations. If there is an error when trying to convert
		 * the string into a value, the called business logic method returns false and actions are taken to
		 * display the error message appropriately.
		 */


		/**********
		 * Private local method to set the value of the first operand given a text value. The method uses the
		 * business logic class to perform the work of checking the string to see it is a valid value and if
		 * so, saving that value internally for future computations. If there is an error when trying to convert
		 * the string into a value, the called business logic method returns false and actions are taken to
		 * display the error message appropriately.
		 */

		/**********
		 * This method is called when an binary operation (expect square root) button has been pressed. It assesses if there are issues
		 * with either of the binary operands or they are not defined. If not return false (there are no issues)
		 *
		 * @return	True if there are any issues that should keep the calculator from doing its work.
		 */


		private boolean binaryOperandIssues() {
			String errorMessage1 = perform.getOperand1ErrorMessage();	// Fetch the error messages, if there are any
			String errorMessage2 = perform.getOperand2ErrorMessage();
			if (errorMessage1.length() > 0) {							// Check the first.  If the string is not empty
				label_errOperand1.setText(errorMessage1);				// there's an error message, so display it.
				if (errorMessage2.length() > 0) {						// Check the second and display it if there is
					label_errOperand2.setText(errorMessage2);			// and error with the second as well.

					return true;										// Return true when both operands have errors
				}
				else {
					return true;										// Return true when only the first has an error
				}
			}
			else if (errorMessage2.length() > 0) {						// No error with the first, so check the second
				label_errOperand2.setText(errorMessage2);				// operand. If non-empty string, display the error
				return true;											// message and return true... the second has an error
			}															// Signal there are issues

																		// If the code reaches here, neither the first nor the second has an error condition. The following code
																		// check to see if the operands are defined.
			if (!perform.getOperand1Defined()) {						// Check to see if the first operand is defined
				label_errOperand1.setText("No value found");			// If not, this is an issue for a binary operator
				if (!perform.getOperand2Defined()) {					// Now check the second operand. It is is also
					label_errOperand2.setText("No value found");		// not defined, then two messages should be displayed

					return true;										// Signal there are issues
				}
				return true;
			}


				else if (!perform.getOperand2Defined()) {					// If the first is defined, check the second. Both
				label_errOperand2.setText("No value found");			// operands must be defined for a binary operator.
				return true;											// Signal there are issues
			}

			return false;												// Signal there are no issues with the operands
			}


		/**********
		 * This method is called when square root button has been pressed. It assesses if there are issues
		 * with either of the binary operand1 or it is not defined. If not return false (there are no issues)
		 * As to perform square root, we only need operand1 thus any value added in the second field is
		 * automatically cleared when square root button is pressed
		 *
		 * @return	True if there are any issues that should keep the calculator from doing its work.
		 */


		private boolean unaryOperandIssues() {
			String errorMessage1 = perform.getOperand1ErrorMessage();
			String errorMessage2 = perform.getOperand2ErrorMessage();
			String errorMessage3 = perform.getOperand3ErrorMessage();
			String errorMessage4 = perform.getOperand4ErrorMessage();
			if (errorMessage1.length() == 0) {
				label_errOperand1.setText(errorMessage1);
				if (errorMessage2.length() > 0) {
					label_errOperand2.setText(errorMessage2);

					return true;
				}
				else {
					return true;
				}
			}
			else if (errorMessage2.length() > 0) {
				label_errOperand2.setText(errorMessage2);
				return true;
			}




			if (errorMessage3.length() == 0) {
				label_errOperand3.setText(errorMessage3);
				if (errorMessage4.length() > 0) {
					label_errOperand4.setText(errorMessage4);

					return true;
				}
				else {
					return true;
				}
			}
			else if (errorMessage4.length() > 0) {
				label_errOperand4.setText(errorMessage4);
				return true;
			}





			if (!perform.getOperand1Defined()) {
				label_errOperand1.setText("");
				if (!perform.getOperand2Defined()) {
					label_errOperand2.setText("");
					if (!perform.getOperand3Defined()) {
						label_errOperand3.setText("");
						if (!perform.getOperand4Defined()) {
							label_errOperand4.setText("");

					return true;
				}
				return true;
			}
					return true;
				}
				return true;
			}


					else if (!perform.getOperand2Defined()) {
				label_errOperand2.setText("No Second Input Required For this Function.");
				return false;
					}


				else if (!perform.getOperand4Defined()) {
					label_errOperand4.setText("No Second Input Required For this Function.");
					return false;


			}
			return false;
				}



		/*******************************************************************************************************
		 * This portion of the class defines the actions that take place when the various calculator
		 * buttons (add, subtract, multiply, divide and square root) are pressed.
		 */

		/**********
		 * This is the add routine
		 *
		 */

		private void addOperands(){
			if(text_Operand1.getText().isEmpty()) {
				text_Operand1.setText("0.0");
			}
			if(text_Operand2.getText().isEmpty()) {
				text_Operand2.setText("0.0");
			}
																			// Check to see if both operands are defined and valid
			if (binaryOperandIssues()) 										// If there are issues with the operands, return
				return;														// without doing the computation

																			// If the operands are defined and valid, request the business logic method to do the addition and return the
																			// result as a String. If there is a problem with the actual computation, an empty string is returned
			String theAnswer = perform.addition();							// Call the business logic add method
			label_errResult.setText("");									// Reset any result error messages from before
			if (theAnswer.length() > 0) {									// Check the returned String to see if it is okay
				Double value = Double.parseDouble(theAnswer);
				if(value != null){
				    if(value == (double) Math.round(value)){
				        if(value/1000000000 > 1.0){
				        	theAnswer = String.format("%.1f G", value/1000000000);
				        }
				        else if(value/1000000 > 1.0){
				        	theAnswer = String.format("%.1f M", value/1000000);
				        }
				        else if(value/1000 > 1.0){
				        	theAnswer = String.format("%.1f K", value/1000);
				        }
				        else{
				        	theAnswer = String.format("%.1f", value);
				        }
				    }
				    else{
				    	theAnswer = String.format("%.2f", value);
				    }
				}

				text_Result.setText(theAnswer);								// If okay, display it in the result field and
				label_Result.setText("Sum");								// change the title of the field to "Sum"
			}
			else {															// Some error occurred while doing the addition.
				text_Result.setText("");									// Do not display a result if there is an error.
				label_Result.setText("Result");								// Reset the result label if there is an error.
				label_errResult.setText(perform.getResultErrorMessage());	// Display the error message.
			}
		}

		private void addOperands1(){
			if(text_Operand3.getText().isEmpty()) {
				text_Operand3.setText("5");
			}
			if(text_Operand4.getText().isEmpty()) {
				text_Operand4.setText("5");
			}
		                                                          	// Check to see if both operands are defined and valid
	if (binaryOperandIssues()) 										// If there are issues with the operands, return
	return;

		String theAnswer1 = perform.addition1();							// Call the business logic add method
		label_errResulterr.setText("");									// Reset any result error messages from before
		if (theAnswer1.length() > 0) {									// Check the returned String to see if it is okay

			Double value = Double.parseDouble(theAnswer1);
			if(value != null){
			    if(value == (double) Math.round(value)){
			        if(value/1000000000 > 1.0){
			        	theAnswer1 = String.format("%.1f G", value/1000000000);
			        }
			        else if(value/1000000 > 1.0){
			        	theAnswer1 = String.format("%.1f M", value/1000000);
			        }
			        else if(value/1000 > 1.0){
			        	theAnswer1 = String.format("%.1f K", value/1000);
			        }
			        else{
			        	theAnswer1 = String.format("%.1f", value);
			        }
			    }
			    else{
			    	theAnswer1 = String.format("%.2f", value);
			    }
			}
			text_Resulterr.setText(theAnswer1);								// If okay, display it in the result field and
			label_Resulterr.setText("Error Term");								// change the title of the field to "Sum"
		}
		else {															// Some error occurred while doing the addition.
			text_Resulterr.setText("");									// Do not display a result if there is an error.
			label_Resulterr.setText("Error Term");								// Reset the result label if there is an error.
			label_errResulterr.setText(perform.getResulterrErrorMessage());	// Display the error message.


		}

	}




		/**********
		 * This is the subtract routine
		 *
		 */
		private void subOperands(){

			if(text_Operand1.getText().isEmpty()) {
				text_Operand1.setText("0.0");
			}
			if(text_Operand2.getText().isEmpty()) {
				text_Operand2.setText("0.0");
			}
			                                                                 // Check to see if both operands are defined and valid
			if (binaryOperandIssues()) 										// If there are issues with the operands, return
				return;														// without doing the computation

																			// If the operands are defined and valid, request the business logic method to do the Subtraction and return the
																			// result as a String. If there is a problem with the actual computation, an empty string is returned
			String theAnswer = perform.subtraction();						// Call the business logic Subtract method
			label_errResult.setText("");									// Reset any result error messages from before
			if (theAnswer.length() > 0) {									// Check the returned String to see if it is okay

				Double value = Double.parseDouble(theAnswer);
				if(value != null){
				    if(value == (double) Math.round(value)){
				        if(value/1000000000 > 1.0){
				        	theAnswer = String.format("%.1f G", value/1000000000);
				        }
				        else if(value/1000000 > 1.0){
				        	theAnswer = String.format("%.1f M", value/1000000);
				        }
				        else if(value/1000 > 1.0){
				        	theAnswer = String.format("%.1f K", value/1000);
				        }
				        else{
				        	theAnswer = String.format("%.1f", value);
				        }
				    }
				    else{
				    	theAnswer = String.format("%.2f", value);
				    }
				}
				text_Result.setText(theAnswer);								// If okay, display it in the result field and
				label_Result.setText("Difference");							// change the title of the field to "Subtraction"
			}
			else {															// Some error occurred while doing the Subtraction.
				text_Result.setText("");									// Do not display a result if there is an error.
				label_Result.setText("Result");								// Reset the result label if there is an error.
				label_errResult.setText(perform.getResultErrorMessage());	// Display the error message.
			}

		}



		private void subOperands1(){
			if(text_Operand3.getText().isEmpty()) {
				text_Operand3.setText("5");
			}
			if(text_Operand4.getText().isEmpty()) {
				text_Operand4.setText("5");
			}
			                                                                // Check to see if both operands are defined and valid
			if (binaryOperandIssues()) 										// If there are issues with the operands, return
				return;														// without doing the computation

																			// If the operands are defined and valid, request the business logic method to do the Subtraction and return the
																			// result as a String. If there is a problem with the actual computation, an empty string is returned
			String theAnswer1 = perform.subtraction1();						// Call the business logic Subtract method
			label_errResulterr.setText("");									// Reset any result error messages from before
			if (theAnswer1.length() > 0) {									// Check the returned String to see if it is okay

				Double value = Double.parseDouble(theAnswer1);
				if(value != null){
				    if(value == (double) Math.round(value)){
				        if(value/1000000000 > 1.0){
				        	theAnswer1 = String.format("%.1f G", value/1000000000);
				        }
				        else if(value/1000000 > 1.0){
				        	theAnswer1 = String.format("%.1f M", value/1000000);
				        }
				        else if(value/1000 > 1.0){
				        	theAnswer1 = String.format("%.1f K", value/1000);
				        }
				        else{
				        	theAnswer1 = String.format("%.1f", value);
				        }
				    }
				    else{
				    	theAnswer1 = String.format("%.2f", value);
				    }
				}
				text_Resulterr.setText(theAnswer1);								// If okay, display it in the result field and
				label_Resulterr.setText("Error Term");							// change the title of the field to "Subtraction"
			}
			else {															// Some error occurred while doing the Subtraction.
				text_Resulterr.setText("");									// Do not display a result if there is an error.
				label_Resulterr.setText("Error Term");								// Reset the result label if there is an error.
				label_errResulterr.setText(perform.getResulterrErrorMessage());	// Display the error message.
			}

		}








		/**********
		 * This is the multiply routine
		 *
		 */
		private void mpyOperands(){
			if(text_Operand1.getText().isEmpty()) {
				text_Operand1.setText("0.0");
			}
			if(text_Operand2.getText().isEmpty()) {
				text_Operand2.setText("0.0");
			}
			// Check to see if both operands are
			if (binaryOperandIssues()) 											// If there are issues with the operands, return
				return;															// without doing the computation

																				// If the operands are defined and valid, request the business logic method to do the Multiplication and return the
																				// result as a String. If there is a problem with the actual computation, an empty string is returned
			String theAnswer = perform.multiplication();						// Call the business logic product method
			label_errResult.setText("");										// Reset any result error messages from before
			if (theAnswer.length() > 0) {										// Check the returned String to see if it is okay

				Double value = Double.parseDouble(theAnswer);
				if(value != null){
				    if(value == (double) Math.round(value)){
				        if(value/1000000000 > 1.0){
				        	theAnswer = String.format("%.1f G", value/1000000000);
				        }
				        else if(value/1000000 > 1.0){
				        	theAnswer = String.format("%.1f M", value/1000000);
				        }
				        else if(value/1000 > 1.0){
				        	theAnswer = String.format("%.1f K", value/1000);
				        }
				        else{
				        	theAnswer = String.format("%.1f", value);
				        }
				    }
				    else{
				    	theAnswer = String.format("%.2f", value);
				    }
				}
				text_Result.setText(theAnswer);									// If okay, display it in the result field and
				label_Result.setText("Product");								// change the title of the field to "Multiplication"
			}
			else {																// Some error occurred while doing the Multiplication.
				text_Result.setText("");										// Do not display a result if there is an error.
				label_Result.setText("Result");									// Reset the result label if there is an error.
				label_errResult.setText(perform.getResultErrorMessage());		// Display the error message.
			}

		}



		private void mpyOperands1(){
			if(text_Operand3.getText().isEmpty()) {
				text_Operand3.setText("5");
			}
			if(text_Operand4.getText().isEmpty()) {
				text_Operand4.setText("5");
			}
			// Check to see if both operands are
			if (binaryOperandIssues()) 											// If there are issues with the operands, return
				return;															// without doing the computation

																				// If the operands are defined and valid, request the business logic method to do the Multiplication and return the
																				// result as a String. If there is a problem with the actual computation, an empty string is returned
			String theAnswer1 = perform.multiplication1();						// Call the business logic Product method
			label_errResulterr.setText("");										// Reset any result error messages from before
			if (theAnswer1.length() > 0) {										// Check the returned String to see if it is okay

				Double value = Double.parseDouble(theAnswer1);
				if(value != null){
				    if(value == (double) Math.round(value)){
				        if(value/1000000000 > 1.0){
				        	theAnswer1 = String.format("%.1f G", value/1000000000);
				        }
				        else if(value/1000000 > 1.0){
				        	theAnswer1 = String.format("%.1f M", value/1000000);
				        }
				        else if(value/1000 > 1.0){
				        	theAnswer1 = String.format("%.1f K", value/1000);
				        }
				        else{
				        	theAnswer1 = String.format("%.1f", value);
				        }
				    }
				    else{
				    	theAnswer1 = String.format("%.2f", value);
				    }
				}
				text_Resulterr.setText(theAnswer1);									// If okay, display it in the result field and
				label_Resulterr.setText("Error Term");								// change the title of the field to "Multiplication"
			}
			else {																// Some error occurred while doing the Multiplication.
				text_Resulterr.setText("");										// Do not display a result if there is an error.
				label_Resulterr.setText("Error Term");									// Reset the result label if there is an error.
				label_errResulterr.setText(perform.getResulterrErrorMessage());		// Display the error message.
			}

		}







		/**********
		 * This is the divide routine.  If the divisor is zero, the divisor is declared to be invalid.
		 *
		 */
		private void divOperands(){
			if(text_Operand1.getText().isEmpty()) {
				text_Operand1.setText("0.0");
			}
			if(text_Operand2.getText().isEmpty()) {
				text_Operand2.setText("0.0");
			}

			if (binaryOperandIssues()) 										// If there are issues with the operands, return
				return;														// without doing the computation
			double x = Double.parseDouble(text_Operand2.getText());
			if (x==0f) {
				label_errResult.setText("Divide by zero is not allowed");
				text_Result.setText("");

			}
			else {String theAnswer = perform.division();					// Call the business logic Division method
			label_errResult.setText("");									// Reset any result error messages from before
			if (theAnswer.length() > 0) {									// Check the returned String to see if it is okay

				Double value = Double.parseDouble(theAnswer);
				if(value != null){
				    if(value == (double) Math.round(value)){
				        if(value/1000000000 > 1.0){
				        	theAnswer = String.format("%.1f G", value/1000000000);
				        }
				        else if(value/1000000 > 1.0){
				        	theAnswer = String.format("%.1f M", value/1000000);
				        }
				        else if(value/1000 > 1.0){
				        	theAnswer = String.format("%.1f K", value/1000);
				        }
				        else{
				        	theAnswer = String.format("%.1f", value);
				        }
				    }
				    else{
				    	theAnswer = String.format("%.2f", value);
				    }
				}
				text_Result.setText(theAnswer);								// If okay, display it in the result field and
				label_Result.setText("Division");							// change the title of the field to "Divide"
			}
			else {															// Some error occurred while doing the division.
				text_Result.setText("");									// Do not display a result if there is an error.
				label_Result.setText("Result");								// Reset the result label if there is an error.
				label_errResult.setText(perform.getResultErrorMessage());	// Display the error message.
			}

			}
		}



		private void divOperands1(){
			if(text_Operand3.getText().isEmpty()) {
				text_Operand3.setText("5");
			}
			if(text_Operand4.getText().isEmpty()) {
				text_Operand4.setText("5");
			}

			if (binaryOperandIssues()) 										// If there are issues with the operands, return
				return;														// without doing the computation



			String theAnswer1 = perform.division1();					// Call the business logic Division method
			label_errResulterr.setText("");									// Reset any result error messages from before
			if (theAnswer1.length() > 0) {									// Check the returned String to see if it is okay

				Double value = Double.parseDouble(theAnswer1);
				if(value != null){
				    if(value == (double) Math.round(value)){
				        if(value/1000000000 > 1.0){
				        	theAnswer1 = String.format("%.1f G", value/1000000000);
				        }
				        else if(value/1000000 > 1.0){
				        	theAnswer1 = String.format("%.1f M", value/1000000);
				        }
				        else if(value/1000 > 1.0){
				        	theAnswer1 = String.format("%.1f K", value/1000);
				        }
				        else{
				        	theAnswer1 = String.format("%.1f", value);
				        }
				    }
				    else{
				    	theAnswer1 = String.format("%.2f", value);
				    }
				}
				text_Resulterr.setText(theAnswer1);								// If okay, display it in the result field and
				label_Resulterr.setText("Error Term");							// change the title of the field to "Divide"
			}
			else {															// Some error occurred while doing the division.
				text_Resulterr.setText("");									// Do not display a result if there is an error.
				label_Resulterr.setText("Error Term");								// Reset the result label if there is an error.
				label_errResulterr.setText(perform.getResulterrErrorMessage());	// Display the error message.
			}

			}

















		/**********
		 * This is the square root routine.
		 *
		 */
		private void sqrtOperands(){
			if(text_Operand1.getText().isEmpty()) {
				text_Operand1.setText("0.0");
			}

																			// Check to see if both operands are defined and valid
			if (unaryOperandIssues());										// If there are issues with the operands, return
															// without doing the computation

			if (text_Operand2.getLength() != 0) {
				text_Operand2.setText("");
				label_errOperand2.setText("Second Input not Required.");



			}

			                                                                 // If the operands are defined and valid, request the business logic method to do the Square Root  and return the
																			// result as a String. If there is a problem with the actual computation, an empty string is returned
			String theAnswer = perform.squareroot();						// Call the business logic Root method
			label_errResult.setText("");									// Reset any result error messages from before
			if (theAnswer.length() > 0) {									// Check the returned String to see if it is okay
				text_Result.setText(theAnswer);								// If okay, display it in the result field and
				label_Result.setText("Square Root");						// change the title of the field to "Square Root"
				}
			else {															// Some error occurred while doing the Square Root.
				text_Result.setText("");									// Do not display a result if there is an error.
				label_Result.setText("Result");								// Reset the result label if there is an error.
				label_errResult.setText(perform.getResultErrorMessage());	// Display the error message.
			}

		}



	private void sqrtOperands1(){
		if(text_Operand3.getText().isEmpty()) {
			text_Operand3.setText("5");
		}

		// Check to see if both operands are defined and valid
	if (unaryOperandIssues());										// If there are issues with the operands, return
	// without doing the computation

	if (text_Operand4.getLength() != 0) {
	text_Operand4.setText("");
	label_errOperand4.setText("Second Input not Required.");








	}

	     // If the operands are defined and valid, request the business logic method to do the Square Root and return the
		// result as a String. If there is a problem with the actual computation, an empty string is returned
	String theAnswer1 = perform.squareroot1();						// Call the business logic Square Root method
	label_errResulterr.setText("");									// Reset any result error messages from before
	if (theAnswer1.length() > 0) {									// Check the returned String to see if it is okay
	text_Resulterr.setText(theAnswer1);								// If okay, display it in the result field and
	label_Resulterr.setText("Error Term");						// change the title of the field to "Square Root"
	}
	else {															// Some error occurred while doing the Square Root.
	text_Resulterr.setText("");									// Do not display a result if there is an error.
	label_Resulterr.setText("Error Term");								// Reset the result label if there is an error.
	label_errResulterr.setText(perform.getResulterrErrorMessage());	// Display the error message.
	}

	}




	}

