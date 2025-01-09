document.getElementById('paymentForm').addEventListener('submit', function(event) {
  event.preventDefault(); // Prevent the form from submitting normally

  // Capture form values
  const email = document.getElementById('email').value;
  const amount = document.getElementById('amount').value;

  // Get button elements
  const payButton = document.getElementById("payButton");
  const buttonText = payButton.querySelector(".button-text");
  const loader = payButton.querySelector(".loader");

  // Show loader and disable button
  buttonText.style.display = "none";
  loader.style.display = "inline-block";
  payButton.disabled = true;

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
  .then(response => {
    if (!response.ok) {
      throw new Error('Failed to initialize payment');
    }
    return response.json();
  })
  .then(result => {
    console.log('Server Response:', result);

    if (result && result.data && result.data.authorization_url) {
      const authorizationUrl = result.data.authorization_url;

      // Redirect to Paystack payment page
      window.location.href = authorizationUrl;
    } else {
      throw new Error('Invalid server response');
    }
  })
  .catch(error => {
    console.error('Error:', error);
    alert('Please try again the server is spinnng up.: ' + error);
  })
  .finally(() => {
    // Hide loader and enable button
    buttonText.style.display = "inline";
    loader.style.display = "none";
    payButton.disabled = false;
  });
});
