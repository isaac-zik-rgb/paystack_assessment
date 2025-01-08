

document.getElementById('paymentForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevent the form from submitting normally
     // Capture form values
     const email = document.getElementById('email').value;
     const amount = document.getElementById('amount').value;

     // Prepare data to send to the server
     const data = { email, amount };

     // Send data to the server using fetch
     fetch('https://paystack-assessment.onrender.com/api/paystack/payment/initialize', {
       method: 'POST',
       headers: {
         'Content-Type': 'application/json'
       },
       body: JSON.stringify(data) // Convert data to JSON
     })
     .then(response => response.json())
     .then(result => {
       console.log('Server Response:', result);
       const responseData = result.data;
       const authorizationUrl = responseData.authorization_url;
      window.location.href = authorizationUrl; // Redirect to Paystack payment page
       alert('Payment initialization successful!');
       const popup = new PaystackPop()
        popup.resumeTransaction(access_code)
     })
     .catch(error => {
       console.error('Error:', error);
       alert('An error occurred while processing your payment try again!.: ');
     });
   
});